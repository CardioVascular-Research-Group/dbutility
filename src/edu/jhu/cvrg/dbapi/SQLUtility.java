package edu.jhu.cvrg.dbapi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
Copyright 2013 Johns Hopkins University Institute for Computational Medicine

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

/**
 *  @author Brandon Benitez
 */

public class SQLUtility {
	
	private static final SQLUtility sqlUtility = new SQLUtility();
	private Connection con = null;
	private String sqlUser = "";
	private String sqlPassword = "";
	private String sqlURL = "";
	private String sqlDriver = "";
	
	private String CONFIGURATION_FILENAME = "/resources/database.config";
	
	public static SQLUtility getInstance() {
		return sqlUtility;
	}
	
	private SQLUtility() {
		Properties props = new Properties();
		
	    try {          
	           InputStream stream = DatabaseProperties.class.getResourceAsStream(CONFIGURATION_FILENAME);

	           props.load(stream);

	           	this.sqlUser = props.getProperty("mySQLUser", "missing");
		        this.sqlPassword = props.getProperty("mySQLPassword", "missing");
		        this.sqlURL = props.getProperty("mySQLURL", "missing");
		        this.sqlDriver = props.getProperty("mySQLDriver", "missing");
		        
		        
	       } catch (FileNotFoundException e) {
	           e.printStackTrace();
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
		
		
	}
	
	public int executeWriteQuery(String sqlStatement) {
		
		int rc = 0;
		
		try {
			Class.forName(this.sqlDriver);
			con = DriverManager.getConnection(sqlURL, this.sqlUser, this.sqlPassword);
			Statement stmt = con.createStatement();
			System.out.println("insertSQL: " + sqlStatement);
			rc = stmt.executeUpdate(sqlStatement);
		} catch (ClassNotFoundException classEx) {
			System.out.println("Unable to find the class for the SQL Driver:  " + this.sqlDriver);
			classEx.printStackTrace();
			
		} catch (SQLException sqlEx) {
			System.out.println("The SQL statement is not valid");
			sqlEx.printStackTrace();
		} catch (Exception ex) {
			System.out.println("An unknown error has occured");
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return rc;
	}
	
	public ResultSet executeReadQuery(String sqlStatement) {
		ResultSet rs = null;
		
		try {
		Class.forName(this.sqlDriver);
		Connection con = DriverManager.getConnection(this.sqlURL, this.sqlUser, this.sqlPassword);
		Statement stmt = con.createStatement();
		System.out.println("fetchSQL: " + sqlStatement);
		rs = stmt.executeQuery(sqlStatement);
		} catch (ClassNotFoundException classEx) {
			System.out.println("Unable to find the class for the SQL Driver:  " + this.sqlDriver);
			classEx.printStackTrace();	
		} catch (SQLException sqlEx) {
			System.out.println("The SQL statement is not valid");
			sqlEx.printStackTrace();
		} catch (Exception ex) {
			System.out.println("An unknown error has occured");
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return rs;
		
	}
}

package edu.jhu.cvrg.dbapi;

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
* @author Chris Jurado
* @author Brandon Benitez
* 
*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * A utility class that reads in the database properties from the configuration file.  It passes that information back to the
 * DBUtility class and subclasses.  
 * 
 *
 */
public class DatabaseProperties {
	
//	private static final DatabaseProperties propertiesUtility = new DatabaseProperties();
	private String CONFIGURATION_FILENAME = "/resources/database.config";
	private String dbUserName = "";
	private String dbUserPassword = "";
	private String dbURI = "";
	private String dbDriver = "";
	private String dbMainDatabase = "";

	
	public static DatabaseProperties getInstance(){

//		return propertiesUtility;
		return new DatabaseProperties();
	}
	
	public static DatabaseProperties getInstance(String dbUserName, String dbUserPassword, String dbURI, 
			String dbDriver, String dbMainDatabase){
		
//		System.out.println("Initializing properties.");
		DatabaseProperties preLoadedPropertiesUtility = new DatabaseProperties(dbUserName, dbUserPassword, dbURI, dbDriver, dbMainDatabase);

		return preLoadedPropertiesUtility;
	}
	
	private DatabaseProperties(String dbUserName, String dbUserPassword, String dbURI, 
			String dbDriver, String dbMainDatabase){

		// System.out.println("Getting properties.");
		
		this.dbUserName = dbUserName;
		this.dbUserPassword = dbUserPassword;
		this.dbURI = dbURI;
		this.dbDriver = dbDriver;
		this.dbMainDatabase = dbMainDatabase;
		
		// System.out.println("Got properties.");
	}
	
	
	
	
	
	/**
	 *  Creates a new instance of the object, pulling in the database configuration properties in the process.
	 */
	private DatabaseProperties(){
//
//		Properties props = new Properties();
//		
//	    try {          
//	           InputStream stream = DatabaseProperties.class.getResourceAsStream(CONFIGURATION_FILENAME);
//
//	           props.load(stream);
//
//	           	this.dbUserName = props.getProperty("dbUser", "missing");
//		        this.dbUserPassword = props.getProperty("dbPassword", "missing");
//		        this.dbURI = props.getProperty("dbURI", "missing");
//		        this.dbDriver = props.getProperty("dbDriver", "missing");
//	           	this.dbMainDatabase = props.getProperty("dbMainDatabase", "missing");
//		        
//	       } catch (FileNotFoundException e) {
//	           e.printStackTrace();
//	       } catch (IOException e) {
//	           e.printStackTrace();
//	       }
	}
	
	// Again, debating over whether to make this public or not
	public String getDBUser() {
		return dbUserName;
	}

	// Same with this one.
	public String getDBPassword() {
		return dbUserPassword;
	}
	
	/**
	 * Retrieves the driver in the configuration file.
	 * 
	 */
	public String getDriver() {
		return dbDriver;
	}

	/**
	 * Retrieves the URI in the configuration file.
	 * 
	 */
	public String getURI() {
		return dbURI;
	}

	/**
	 * Retrieves the Main Database listed in the configuration file.
	 * 
	 */
	public String getMainDatabase() {
		return dbMainDatabase;
	}
}

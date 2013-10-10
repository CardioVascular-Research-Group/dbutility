/**
 * A CVRG database API that can be used with multiple database types.
 * 
 */
package edu.jhu.cvrg.dbapi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

/**
 * The base class that forms the basis for all other utilities.  This class is to be the middleware that provides an interface between the application and
 * the database.  It will hold database functions related to setting up database properties, executing queries, and any other functions as needed.  It does not actually create
 * the query statements.  Set up an XQueryBuilder based class to do that.
 *  
 *  @see  XQueryBuilder
 *
 */
public abstract class DBUtility {
	
	protected String dbDriver = "";
	protected String dbUserName = "";
	protected String dbUserPassword = "";
	protected String dbURI = "";
	protected DatabaseProperties dbHandle;
	
	//protected String CONFIGURATION_FILENAME = "/resources/database.config";
	
	/**
	 * Sets up the database properties with a predetermined configuration file.
	 * 
	 */
	
	public DBUtility(String dbUserName, String dbUserPassword, String dbURI, 
			String dbDriver, String dbMainDatabase){
		
		this.dbHandle = DatabaseProperties.getInstance(dbUserName, dbUserPassword, dbURI,	dbDriver, dbMainDatabase);
		initialize();
	}
	
	
	public DBUtility() {
		
		this.dbHandle = DatabaseProperties.getInstance();
		initialize();
		
	}
	
	private void initialize(){
		
	    try {          

           	this.dbUserName = dbHandle.getDBUser();
	        this.dbUserPassword = dbHandle.getDBPassword();
	        this.dbURI = dbHandle.getURI();
	        this.dbDriver = dbHandle.getDriver();
	        
       } catch (Exception e) {
           e.printStackTrace();
       }
		
	}
	
	//*************************************
	// Accessors
	//*************************************
	
	/**
	 * 	Returns the name of the Database driver being used
	 */
	public String getDriver() {
		return this.dbDriver;
	}
	
	/**
	 *  Returns the name of the URI of the database being used 
	 */
	public String getURI() {
		return this.dbURI;
	}
	
	// Not sure if I want to be able to return this.  I might remove this accessor.
	public String getDBUser() {
		return this.dbUserName;
	}
	
	// Same with this one.  Both need to be hidden for security reasons.
	public String getDBPassword() {
		return this.dbUserPassword;
	}

}

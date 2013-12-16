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
 *  @author Brandon Benitez
 */

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.CompiledExpression;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XQueryService;

public abstract class XMLUtility extends DBUtility {
	
	protected String dbMainCollection = "/db";
	
	private Collection xmlCollection = null;
	
	public XMLUtility() {
		super();
		
	    try {          

           	this.dbMainCollection = dbHandle.getMainDatabase();
	        
       } catch (Exception e) {
           e.printStackTrace();
       }
	}
	
	public XMLUtility(String dbUserName, String dbUserPassword, String dbURI, 
			String dbDriver, String dbMainDatabase){
		super(dbUserName, dbUserPassword, dbURI, dbDriver, dbMainDatabase);
		
	    try {          

           	this.dbMainCollection = dbHandle.getMainDatabase();
	        
       } catch (Exception e) {
           e.printStackTrace();
       }
	}
	
	public ResourceSet executeQuery(String sQuery) {
		ResourceSet resultSet;
		if(xmlCollection == null){
			resultSet = executeQuery(sQuery, this.dbMainCollection);	
		}else{
			resultSet  = executeQueryOnly(sQuery);
		}
		
		
		return resultSet;
	}
	
	public void initialize(){
		
		try {
			String sDBFullPath = dbURI + this.dbMainCollection;

			Class<?> cl = Class.forName(dbDriver);
			Database connection = (Database) cl.newInstance();
			connection.setProperty("create-database", "true");
			DatabaseManager.registerDatabase(connection);

			xmlCollection = DatabaseManager.getCollection(sDBFullPath, dbUserName, dbUserPassword);
			
		} catch (ExceptionInInitializerError e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public void close(){
		if (xmlCollection != null) {
			try {
				xmlCollection.close();
			} catch (XMLDBException xmlEx) {
				xmlEx.printStackTrace();
			}
		}
	}
	
	public boolean isClosed(){
		try {
			return xmlCollection == null || !xmlCollection.isOpen();
		} catch (XMLDBException e) {
			e.printStackTrace();
			return true;
		}
		
	}
	
	protected ResourceSet executeQueryOnly(String sQuery) {
		ResourceSet queryResult = null;
		try {

			XQueryService subjectQuery = (XQueryService) xmlCollection.getService("XQueryService", "1.0");
			subjectQuery.setProperty("indent", "yes");
			
			CompiledExpression query = subjectQuery.compile(sQuery);
			
			queryResult = subjectQuery.execute(query);

		} catch (ExceptionInInitializerError e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return queryResult;

	}
	
	@Deprecated
	protected ResourceSet executeQuery(String sQuery, String dbCollection) {
		// TODO Auto-generated method stub
		ResourceSet queryResult = null;
		Collection xmlCollection = null;

		
		try {
			String sDBFullPath = dbURI + dbCollection;

			Class<?> cl = Class.forName(dbDriver);
			Database connection = (Database) cl.newInstance();
			connection.setProperty("create-database", "true");
			DatabaseManager.registerDatabase(connection);

			xmlCollection = DatabaseManager.getCollection(sDBFullPath, dbUserName, dbUserPassword);
			XQueryService subjectQuery = (XQueryService) xmlCollection.getService("XQueryService", "1.0");
			subjectQuery.setProperty("indent", "yes");
			//queryResult = subjectQuery.query(sQuery);
			CompiledExpression query = subjectQuery.compile(sQuery);
				
			queryResult = subjectQuery.execute(query);

		} catch (ExceptionInInitializerError e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (xmlCollection != null) {
				try {
					xmlCollection.close();
				} catch (XMLDBException xmlEx) {
					xmlEx.printStackTrace();
				}
			}
		}

		return queryResult;

	}
	

}

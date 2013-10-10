/**
 * 
 */
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
public abstract class XQueryBuilder {
	
	// control of the database happens here
	//protected ExistUtility existAccessor;
	
	// variables to store the actual clauses passed into the database
	protected String forClause = "";
	protected String letClause = "";
	protected String whereClause = "";
	protected String orderByClause = "";
	protected String returnClause = "";
	protected String dbURI = "";
	protected String dbCollection = "";
	
	// TODO:  Other variables will be added to accomodate the specific types of XML and queries to be built
	
	public XQueryBuilder(String URI, String collection) {
		this.dbURI = URI;
		this.dbCollection = collection;
	}
	
	// TODO:  Override with default URI and Collection in derived class
	protected XQueryBuilder() {
		forClause = "for";
	}
	
	//*** This is the default version of these sets of methods.  The derived classes may overload this as needed ***
	public abstract String defaultFor();
	
	public abstract String defaultLet();
	
	public abstract String defaultWhere();
	
	public void and() {
		this.whereClause = this.whereClause + " and ";
	}
	
	public abstract String defaultOrderBy();
	
	public abstract String defaultReturn();
	
	public abstract String defaultBracket();
	
	// *************************************************************************************************************
	
	// *** These next set of functions will not require overloaded versions for different query types ***
	
	public abstract String insert(String newNode, EnumXMLInsertLocation locale, String anchorNode);
	
	public abstract String update(String oldNode, String newNode, String condition);
	
	public abstract String modify(String nodeToModify, String newValue, String condition);
	
	public abstract String delete(String nodeToDelete, String condition);
	
	//**************************************************************************************************************
	
	protected String getURI() {
		return this.dbURI;
	}
	
	// TODO:  Make a function for each derived class to get the specific collection required
	protected String getCollection() {
		return this.dbCollection;
	}
	
	
}

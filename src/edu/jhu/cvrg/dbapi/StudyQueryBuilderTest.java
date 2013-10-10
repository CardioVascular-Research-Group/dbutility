package edu.jhu.cvrg.dbapi;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XQueryService;

public class StudyQueryBuilderTest extends XQueryBuilder {

	public StudyQueryBuilderTest(String URI, String collection, String dbDriver) {
		super(URI, collection);
		// TODO Auto-generated constructor stub
	}
	
	// The default constructor has been made private so it cannot be invoked.  A developer MUST provide a URI and collection
	private StudyQueryBuilderTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String defaultFor() {
		// Create a basic study entry query
		
		 this.forClause = "for $x in collection('" + this.dbCollection + "')//record ";
		
		
		return this.forClause;
	}

	@Override
	public String defaultLet() {
		// TODO fill this in later
		return null;
	}

	@Override
	public String defaultWhere() {
		// TODO Auto-generated method stub
		String userID = "demo3";
		
		 this.whereClause = "where collection('" + this.dbCollection + "')//record/studyEntry/submitterID=\"" + userID + "\" ";
		return this.whereClause;
	}

	@Override
	public String defaultOrderBy() {
		// TODO Auto-generated method stub
		this.orderByClause = " order by $x/studyEntry/subjectID ";
		return this.orderByClause;
	}

	@Override
	public String defaultReturn() {
		// TODO Auto-generated method stub
		 this.returnClause = " return $x/studyEntry";
		return this.returnClause;
	}

	@Override
	public String defaultBracket() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert(String newNode, EnumXMLInsertLocation locale,
			String anchorNode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(String oldNode, String newNode, String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modify(String nodeToModify, String newValue, String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String nodeToDelete, String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}

package edu.jhu.cvrg.dbapi.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DBUtilityProperties {

	private static String PROPERTIES_PATH = "/conf/dbutility.properties";
	private static Properties prop;
	private static DBUtilityProperties singleton;
	private static File propertiesFile = null;
	private static long lastChange = 0;
	

	private DBUtilityProperties() {
		prop = new Properties();
		propertiesFile = new File(System.getProperty("catalina.home")+PROPERTIES_PATH);
		loadProperties();
	}
	
	public static DBUtilityProperties getInstance(){
		if(singleton == null){
			singleton = new DBUtilityProperties();
		}
		return singleton;
	}
	
	public String getProperty(String propertyName){
		loadProperties();
		return prop.getProperty(propertyName);
	}
	
	private void loadProperties(){
		try {
			if(propertiesFile.lastModified() > lastChange){
				prop.clear();
				prop.load(new FileReader(propertiesFile));
				lastChange = propertiesFile.lastModified();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public static final String EXISTS_DB_USER = "dbUser";
	public static final String EXISTS_DB_PASSWORD = "dbPassword";
	public static final String EXISTS_DB_URI = "dbURI";
	public static final String EXISTS_DB_MAIN_DATABASE = "dbMainDatabase";
	public static final String EXISTS_DB_ANALYSIS_DATABASE_NAME = "dbAnalysisDatabase";
	public static final String EXISTS_DB_ANALYSIS_RESULTS = "dbAnalysisResults";
	public static final String EXISTS_DB_DRIVER = "dbDriver";
	public static final String HIBERNATE_DRIVER_CLASS = "jdbc.default.driverClassName";
	public static final String HIBERNATE_DB_URL = "jdbc.default.url";
	public static final String HIBERNATE_DB_PASSWORD = "jdbc.default.password";
	public static final String HIBERNATE_DB_USERNAME = "jdbc.default.username";
	public static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";

}

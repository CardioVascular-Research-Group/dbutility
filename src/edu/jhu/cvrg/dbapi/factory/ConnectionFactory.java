package edu.jhu.cvrg.dbapi.factory;

public class ConnectionFactory {

	public static Connection createConnection(){
		return ConnectionFactory.createConnection(ConnectionType.HIBERNATE);
	}
	
	public static Connection createConnection(ConnectionType type){
		Connection con = null;
		
		switch (type) {
			case LIFERAY_SOAP:
				con = new LiferaySOAPConnection();
				break;
			case LIFERAY_LOCAL:
				con = new LiferayLocalConnection();
				break;
			case EXISTS:
				con = new ExistsConnection();
				break;
			case JDBC:
				con = new JDBCConnection();
				break;
			case HIBERNATE:
				con = new HibernateConnection();
				break;
			default:
				break;
		}
		
		return con;
	}
		
}

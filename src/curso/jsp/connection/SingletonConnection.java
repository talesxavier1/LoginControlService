package curso.jsp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	
	private static String URL = "jdbc:postgresql://localhost:5432/Usuarios";
	private static String USER = "postgres";
	private static String PASSWORD = "admin";
	private static Connection connection = null;
	
	static {
		connect();
	}
	
	private static void connect() {
		
		try {
			Class.forName("org.postgresql.Driver");
			if (connection == null) {
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				connection.setAutoCommit(false);
			}
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}

package curso.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import curso.jsp.connection.SingletonConnection;

public class DaoLogin {
	private Connection connection = null;
	
	public DaoLogin() {
		connection = SingletonConnection.getConnection();
	}
	
	public String validarUsuario(String email, String password) {
		
		try {
			
			String SQL = String.format("SELECT user_name FROM public.usuario WHERE user_password='%s' and user_email='%s'", password,email);
			PreparedStatement statement = connection.prepareStatement(SQL);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getString("user_name");
			}
			else {
				return null;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}

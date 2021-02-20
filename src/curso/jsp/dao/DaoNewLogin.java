package curso.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import curso.jsp.connection.SingletonConnection;
import curso.jsp.models.userModel;

public class DaoNewLogin {
	
	
	public boolean cadastrar(userModel user){
		DaoLogin daoLogin = new DaoLogin();
		Connection connection = SingletonConnection.getConnection();
		if ((daoLogin.validarUsuario(user.getEmail(), user.getPassword())) != null) {
			return false;
		}
		else {
			try {
			String SQL= String.format("INSERT INTO public.usuario(user_name, user_password, user_email) VALUES ('%s', '%s', '%s');", 
					user.getNome(),
					user.getPassword(),
					user.getEmail());
			PreparedStatement statement = connection.prepareStatement(SQL);
			statement.execute();
			connection.commit();
			return true;
			}catch (Exception e) {
				e.printStackTrace();
				try {
					connection.rollback();
				}catch (Exception f) {
					f.printStackTrace();
				}
				return false;
			}
		}
	}
	
}

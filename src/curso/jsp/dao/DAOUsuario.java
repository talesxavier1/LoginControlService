package curso.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import curso.jsp.connection.SingletonConnection;
import curso.jsp.models.UserModel;

public class DAOUsuario {

	public boolean cadastrar(UserModel user) {
		Connection connection = SingletonConnection.getConnection();
		if ((checarExistencia(user) == false)) {
			System.out.println("Usuario Já está cadastrado. Mensagem emitida pela classe DaoUsuario.java");
			return false;
		} else {
			try {
				String SQL = String.format(
						"INSERT INTO public.usuario(user_name, user_password, user_email, user_telefone) VALUES ('%s', '%s', '%s', '%s');",
						user.getNome(), user.getPassword(), user.getEmail(), user.getTelefone());
				PreparedStatement statement = connection.prepareStatement(SQL);
				statement.execute();
				connection.commit();
				System.out.println(
						"usuario: " + user.getNome() + " Cadastrado. Mensagem emitida pela classe DaoUsuario.");
				return true;
			} catch (Exception e) {
				System.out.println(
						"Erro na criacao do usuario: " + user.getNome() + ". Mensagem emitida pela classe DaoUsuario.");
				e.printStackTrace();
				try {
					connection.rollback();
				} catch (Exception f) {
					f.printStackTrace();
				}
				return false;
			}
		}
	}

	public List<UserModel> listarUsuarios() {

		List<UserModel> listaUsuarios = new ArrayList<UserModel>();
		String SQL = "SELECT * FROM public.usuario;";
		try {
			PreparedStatement statement = SingletonConnection.getConnection().prepareStatement(SQL);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				UserModel userModel = new UserModel();
				userModel.setId(resultSet.getLong("user_id"));
				userModel.setNome(resultSet.getString("user_name"));
				userModel.setEmail(resultSet.getString("user_email"));
				userModel.setPassword(resultSet.getString("user_password"));
				userModel.setTelefone(resultSet.getString("user_telefone"));
				listaUsuarios.add(userModel);
			}
			System.out.println("Lista de usuarios emitida. Mensagem emitida pela classe DaoUsuario.");
		} catch (Exception e) {
			System.out.println("Erro ao tentar emitir lista de usuarios. Mensagem emitida pela classe DaoUsuario.");
			e.printStackTrace();
		}
		return listaUsuarios;
	}

	public boolean deletarUsuario(long id) {
		String SQL = String.format("DELETE FROM public.usuario WHERE user_id='%s'", id);
		PreparedStatement statement = null;
		try {
			statement = SingletonConnection.getConnection().prepareStatement(SQL);
			statement.execute();
			statement.getConnection().commit();
			System.out.println("Usuario com o id: " + id + ". Mensagem emitida pela classe DaoUsuario.");
			return true;
		} catch (Exception e) {
			System.out.println(
					"Erro ao tentar excluir usuario com o id: " + id + ". Mensagem emitida pela classe DaoUsuario.");
			e.printStackTrace();
			try {
				statement.getConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}

	public UserModel buscarUsuario(long user_id) {
		try {
			UserModel userModel = new UserModel();
			String SQL = String.format("SELECT * FROM public.usuario WHERE user_id='%s'", user_id);
			Connection connection = SingletonConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				userModel.setId(resultSet.getLong("user_id"));
				userModel.setNome(resultSet.getString("user_name"));
				userModel.setEmail(resultSet.getString("user_email"));
				userModel.setTelefone(resultSet.getString("user_telefone"));
				userModel.setPassword(resultSet.getString("user_password"));
				return userModel;
			} else {
				System.out.println(
						"usuario com o id: " + user_id + " nao encontrado. Erro Emitido pela classe DaoUsuario.");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Erro ao procurar usuario. Erro emitido pela classe DaoUsuario.");
			e.printStackTrace();
		}
		return null;
	}

	public boolean alterarusuario(UserModel user) {

		Connection connection = SingletonConnection.getConnection();
		try {
			String SQL = String.format(
					"UPDATE public.usuario SET user_name='%s', user_password='%s', user_email='%s', user_telefone='%s' WHERE  user_id='%s';",
					user.getNome(), user.getPassword(), user.getEmail(), user.getTelefone(), user.getId());
			PreparedStatement statement = connection.prepareStatement(SQL);
			statement.execute();
			connection.commit();
			System.out
					.println("Usuario com id: " + user.getId() + " alterado. Mensagem emitida pela classe DaoUsuario.");
			return true;
		} catch (Exception e) {
			try {
				connection.rollback();
				System.out.println("Erro ao alterar usuario com id: " + user.getId()
						+ ". Mensagem emitida pela classe DaoUsuario.");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public String validarLogin(String email, String password) {
		
		try {
			Connection connection = SingletonConnection.getConnection();
			String SQL = String.format(
					"SELECT user_name FROM public.usuario WHERE user_password='%s' and user_email='%s'",
					password,
					email);
			PreparedStatement statement = connection.prepareStatement(SQL);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString("user_name");
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean checarExistencia(UserModel user) {
		
		try {
			String SQL = String.format("SELECT * FROM public.usuario WHERE user_email='%s' AND user_id <> '%s'",
					user.getEmail(), user.getId());
			Connection connection = SingletonConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return false;
			} else {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println(
					"Erro durante a verificacao da existencia do usuario. Mensagem emitida pela classe DaoValidacaoUsuario.");
			e.printStackTrace();
			return false;
		}
	}
}

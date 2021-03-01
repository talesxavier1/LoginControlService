package curso.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.util.Which;

import curso.jsp.connection.SingletonConnection;
import curso.jsp.models.ProdutoModel;

public class DAOProduto {

	public boolean cadastrarProduto(ProdutoModel produto) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		try {
			String SQL = String.format(
					"INSERT INTO public.produto(produto_nome, produto_quantidade, produto_valor)VALUES ('%s', %s, %s);",
					produto.getNome(), produto.getQuantidade(), produto.getValor());
			statement = connection.prepareStatement(SQL);
			statement.execute();
			connection.commit();
			return true;
		} catch (Exception e) {
			try {
				connection.rollback();

			} catch (Exception e2) {
				System.out.println("Erro no rollBack. Mensagem emitida pela classe DAOProduto.java");
				e2.printStackTrace();
			}
			System.out.println("Erro nao insercao do produto. Mensagem emitida pela classe DAOProduto.java");
			e.printStackTrace();
		}
		return false;
	}

	public boolean excluirProduto(long produto_id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			String SQL = String.format("DELETE FROM public.produto WHERE produto_id=%s;", produto_id);
			PreparedStatement statement = connection.prepareStatement(SQL);
			statement.execute();
			connection.commit();
			System.out.println(
					"Produto com id " + produto_id + " Excluido. Mensagem emitida pela classe DAOProduto.java");
			return true;
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}

	public boolean alterarProduto(ProdutoModel produto) {
		Connection connection = SingletonConnection.getConnection();
		try {
			if(!checarExistencia(produto)) {
				return false;
			}
			else {
				String SQL = String.format(
						"UPDATE public.produto SET produto_nome='%s', produto_quantidade=%s, produto_valor=%s WHERE produto_id=%s;",
						produto.getNome(), produto.getQuantidade(), produto.getValor(), produto.getId());
				PreparedStatement statement = connection.prepareStatement(SQL);
				statement.execute();
				connection.commit();
				return true;
			}
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
	}


	public boolean checarExistencia(ProdutoModel produto) {
		try {
			Connection connection = SingletonConnection.getConnection();
			String SQL = String.format("SELECT * FROM public.produto WHERE produto_nome='%s' AND produto_id <> '%s'",
					produto.getNome(), produto.getId());
			PreparedStatement statement = connection.prepareStatement(SQL);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				return false;
			}
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao checar Existencia do registro. Mensagem emitida pela classe ProdutoServlet.java");
			e.printStackTrace();
			return false;
		}
	}
	
	public ProdutoModel buscarProduto(String produto_id) {
		try {
			ProdutoModel produto = new ProdutoModel();
			Connection connection = SingletonConnection.getConnection();
			String SQL = String.format("SELECT * FROM public.produto WHERE produto_id=%s", produto_id);
			PreparedStatement statement = connection.prepareStatement(SQL);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				produto.setId(resultSet.getLong("produto_id"));
				produto.setNome(resultSet.getString("produto_nome"));
				produto.setQuantidade(resultSet.getInt("produto_quantidade"));
				produto.setValor(resultSet.getDouble("produto_valor"));
				return produto;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ProdutoModel> listarProdutos() {
		List<ProdutoModel> produtos = new ArrayList<ProdutoModel>();
		Connection connection = SingletonConnection.getConnection();
		try {
			String SQL = "SELECT * FROM public.produto";
			PreparedStatement statement = connection.prepareStatement(SQL);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ProdutoModel produto = new ProdutoModel();
				produto.setId(Long.parseLong(resultSet.getString("produto_id")));
				produto.setNome(resultSet.getString("produto_nome"));
				produto.setQuantidade(Integer.parseInt(resultSet.getString("produto_quantidade")));
				produto.setValor(Double.parseDouble(resultSet.getString("produto_valor")));
				produtos.add(produto);
			}
			System.out.println("Lista de produtos emitida. Mensagem emitida pela classe DAOProduto.java");
			return produtos;
		} catch (Exception e) {
			System.out.println("Erro ao tentar listar os produtos. Mensagem emitida pela classe DAOProduto.java");
			e.printStackTrace();
		}
		return null;
	}
}

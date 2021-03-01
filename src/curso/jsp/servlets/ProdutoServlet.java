package curso.jsp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import curso.jsp.dao.DAOProduto;
import curso.jsp.models.ProdutoModel;

@WebServlet("/ProdutoServlet")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProdutoServlet() {
		super();
	}

	// ProdutoServlet?action=listarProdutos
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOProduto daoProduto = new DAOProduto();
		RequestDispatcher dispatcher = null;
		String action = request.getParameter("action");
		
		if (action.equals("listarProdutos")) {
			dispatcher = request.getRequestDispatcher("ProdutoMostrar.jsp");
			request.setAttribute("ListaProduto", daoProduto.listarProdutos());
		}
		else if (action.equals("excluir")) {
			if(daoProduto.excluirProduto(Long.parseLong(request.getParameter("produtoId")))) {
				dispatcher = request.getRequestDispatcher("ProdutoMostrar.jsp");
				request.setAttribute("ListaProduto", daoProduto.listarProdutos());
			}
			else {
				dispatcher = request.getRequestDispatcher("Erro.jsp");
				request.setAttribute("msg", "Erro ao tentar Excluir produto com id "+ request.getParameter("produtoId"));
			}
		}
		else if (action.equals("Alterar")) {
			dispatcher = request.getRequestDispatcher("ProdutoAlterar.jsp");
			request.setAttribute("user", daoProduto.buscarProduto(request.getParameter("produtoId")));
		}
		else {
			dispatcher = request.getRequestDispatcher("Erro.jsp");
			request.setAttribute("msg", "Erro no metodo get na classe ProdutoServlet.java. ACTION NAO ENCONTRADA");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		RequestDispatcher dispatcher = null;
		DAOProduto daoProduto = new DAOProduto();
		ProdutoModel produto = new ProdutoModel();
		
		if (action.equals("Cadastrar")) {
			produto.setId(0);
			produto.setNome(request.getParameter("txtNome"));
			produto.setQuantidade(Integer.parseInt(request.getParameter("txtQuantidade")));
			produto.setValor(Double.parseDouble(request.getParameter("txtValor")));
			if(daoProduto.checarExistencia(produto)) {
				if (daoProduto.cadastrarProduto(produto)) {
					dispatcher = request.getRequestDispatcher("ProdutoMostrar.jsp");
					request.setAttribute("ListaProduto", daoProduto.listarProdutos());
				}
				else {
					dispatcher = request.getRequestDispatcher("Erro.jsp");
					request.setAttribute("msg", "Erro na insercao do produto. mensagem emitida pela classe ProdutoServlet.java");
				}
			}
			else {
				dispatcher = request.getRequestDispatcher("ProdutoCadastrar.jsp");
				request.setAttribute("msg","Produto Já está cadastrado.");
				request.setAttribute("produto", produto);
			}
		}
		else if (action.equals("listarProdutos")) {
			dispatcher = request.getRequestDispatcher("ProdutoMostrar.jsp");
			request.setAttribute("ListaProduto", daoProduto.listarProdutos());
		}
		else if (action.equals("Alterar")) {
			produto.setId(Long.parseLong(request.getParameter("txtId")));
			produto.setNome(request.getParameter("txtNome"));
			produto.setQuantidade(Integer.parseInt(request.getParameter("txtQuantidade")));
			produto.setValor(Double.parseDouble(request.getParameter("txtValor")));
			if(daoProduto.checarExistencia(produto)){
				if (daoProduto.alterarProduto(produto)) {
					dispatcher = request.getRequestDispatcher("ProdutoMostrar.jsp");
					request.setAttribute("ListaProduto", daoProduto.listarProdutos());
				}else {
					dispatcher = request.getRequestDispatcher("Erro.jsp");
					request.setAttribute("msg", "Erro na alteracao do registro.");
				}
				
			}else {
				dispatcher = request.getRequestDispatcher("ProdutoAlterar.jsp");
				request.setAttribute("user", daoProduto.buscarProduto(String.valueOf(produto.getId())));
				request.setAttribute("msg", "Nome Já Cadastrado");
			}
		}
		else {
			dispatcher = request.getRequestDispatcher("Erro.jsp");
			request.setAttribute("msg", "Erro no metodo post na classe ProdutoServlet. ACTION NAO ENCONTRADA");
		}
		dispatcher.forward(request, response);
	}
}





























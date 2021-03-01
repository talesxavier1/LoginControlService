package curso.jsp.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import curso.jsp.dao.DAOUsuario;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	DAOUsuario usuario = new DAOUsuario();
	private static final long serialVersionUID = 1L;
	
	public LoginServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOUsuario daoLogin = new DAOUsuario();
		RequestDispatcher dispatcher;
		
		String userName = daoLogin.validarLogin(request.getParameter("txtEmail"),
				request.getParameter("txtPassword"));
		
		if (userName != null) {
			dispatcher = request.getRequestDispatcher("AcessoLiberado.jsp");
			request.setAttribute("user_name", userName);
		} else {
			dispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Email ou Password incorreto");
			System.out.println("Acesso negado para os dados "+ request.getParameter("txtEmail")+" "+request.getParameter("txtPassword"));
		}
		dispatcher.forward(request, response);
	}
}

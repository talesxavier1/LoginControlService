package curso.jsp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import curso.jsp.dao.DaoLogin;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public loginServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DaoLogin daoLogin = new DaoLogin();
		RequestDispatcher dispatcher;
		
		String userName = daoLogin.validarUsuario(request.getParameter("txtEmail"),
				request.getParameter("txtPassword"));
		
		if (userName != null) {
			dispatcher = request.getRequestDispatcher("AcessoLiberado.jsp");
			request.setAttribute("user_name", userName);
		} else {
			dispatcher = request.getRequestDispatcher("AcessoNegado.jsp");
		}
		dispatcher.forward(request, response);
	}
}

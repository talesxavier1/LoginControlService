package curso.jsp.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import curso.jsp.dao.DaoNewLogin;
import curso.jsp.models.userModel;

@WebServlet("/cadastroServlet")
public class cadastroServlet extends HttpServlet {
	DaoNewLogin daoNewLogin = new DaoNewLogin();
	private static final long serialVersionUID = 1L;
	
	public cadastroServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher;
		userModel user = new userModel(request.getParameter("txtEmail"), request.getParameter("txtPassword1"),
				request.getParameter("txtNome"));
		if (daoNewLogin.cadastrar(user)) {
			dispatcher = request.getRequestDispatcher("index.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("Erro.jsp");
		}
		dispatcher.forward(request, response);
	}
}

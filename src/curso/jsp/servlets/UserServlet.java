package curso.jsp.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import curso.jsp.dao.DAOUsuario;
import curso.jsp.models.UserModel;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		String parameter = request.getParameter("action");

		if (parameter.equals("listarUsuarios")) {
			DAOUsuario usuario = new DAOUsuario();
			dispatcher = request.getRequestDispatcher("UsuarioMostrar.jsp");
			request.setAttribute("usersList", usuario.listarUsuarios());
		}
		//////////////////////////////////////////
		else if (parameter.equals("excluir")) {
			DAOUsuario usuario = new DAOUsuario();
			if (usuario.deletarUsuario(Long.parseLong(request.getParameter("userId")))) {
				dispatcher = request.getRequestDispatcher("UsuarioMostrar.jsp");
				request.setAttribute("usersList", usuario.listarUsuarios());
			} else {
				dispatcher = request.getRequestDispatcher("Erro.jsp");
			}
		}
		//////////////////////////////////////////
		else if (parameter.equals("alterar")) {
			DAOUsuario daoUsuario = new DAOUsuario();

			UserModel user = daoUsuario.buscarUsuario(Long.parseLong(request.getParameter("userId")));
			if (user != null) {
				dispatcher = request.getRequestDispatcher("UsuarioAlterar.jsp");
				request.setAttribute("user", user);
			} else {
				dispatcher = request.getRequestDispatcher("Erro.jsp");
			}
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		DAOUsuario daoUsuario = new DAOUsuario();
		RequestDispatcher dispatcher = null;
		UserModel user = new UserModel();
		;

		if (action.equals("cadastrar")) {
			user.setEmail(request.getParameter("txtEmail"));
			user.setPassword(request.getParameter("txtPassword1"));
			user.setNome(request.getParameter("txtNome"));
			user.setTelefone(request.getParameter("txtTelefone"));

			if (daoUsuario.cadastrar(user)) {
				dispatcher = request.getRequestDispatcher("index.jsp");
			} else {
				dispatcher = request.getRequestDispatcher("UsuarioCadastro.jsp");
				request.setAttribute("user", user);
				request.setAttribute("msg", "Email já está registrado");
			}
		}
		//////////////////////////////////////////
		else if (action.equals("listarUsuarios")) {
			dispatcher = request.getRequestDispatcher("UsuarioMostrar.jsp");
			request.setAttribute("usersList", daoUsuario.listarUsuarios());

		}
		//////////////////////////////////////////
		else if (action.equals("alterar")) {
			DAOUsuario daoValidacaoUsuario = new DAOUsuario();

			user.setId(Long.parseLong(request.getParameter("txtId")));
			user.setNome(request.getParameter("txtNome"));
			user.setEmail(request.getParameter("txtEmail"));
			user.setTelefone(request.getParameter("txtTelefone"));
			user.setPassword(request.getParameter("txtPassword1"));

			if (daoValidacaoUsuario.checarExistencia(user)) {
				if (daoUsuario.alterarusuario(user)) {
					dispatcher = request.getRequestDispatcher("UsuarioMostrar.jsp");
					request.setAttribute("usersList", daoUsuario.listarUsuarios());
				} else {
					dispatcher = request.getRequestDispatcher("Erro.jsp");
				}
			} else {
				dispatcher = request.getRequestDispatcher("UsuarioAlterar.jsp");
				request.setAttribute("user", user);
				request.setAttribute("msg", "Email já existe");
			}
		}
		//////////////////////////////////////////
		else {
			dispatcher = request.getRequestDispatcher("Erro.jsp");
		}
		dispatcher.forward(request, response);
	}

}

package curso.jsp.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import curso.jsp.connection.SingletonConnection;

@WebFilter(urlPatterns = {"/*"})
public class Filter implements javax.servlet.Filter{
	
	private static Connection connection = null;
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		try {
			arg2.doFilter(arg0, arg1);
			connection.commit();
		}catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void init(FilterConfig arg0) throws ServletException{
		connection = SingletonConnection.getConnection();
	}

}

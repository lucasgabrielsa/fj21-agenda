package br.com.caelum.filtros;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.jdbc.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements Filter {



	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		String uri = ((HttpServletRequest) req).getRequestURI();

		System.out.println(uri + " - CONEXAO ABERTA!");

		Connection connection = null;
		try {
			connection = new ConnectionFactory().getConnection();

			req.setAttribute("connection", connection);

			chain.doFilter(req, res);

			connection.close();

		} catch (Exception e) {
			throw new RuntimeException("Erro no filtro de Conexao" + uri, e);
		} finally {
			System.out.println(uri + " - CONEXAO FECHADA!");

		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

}

package br.com.caelum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String parametro = req.getParameter("logica");
		String nomeClasse = "br.com.caelum.mvc.logica." + parametro;
		
		try {
			
			Class<?> classe = Class.forName(nomeClasse);
			Logica logica = (Logica) classe.newInstance();
			
			//Recebe o String após a execução da lógica
			String paginaRedirecionar = logica.executa(req, res);
			
			req.getRequestDispatcher(paginaRedirecionar).forward(req, res);
			
		} catch(Exception e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
		
	}

}

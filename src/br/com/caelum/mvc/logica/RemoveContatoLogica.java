package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.mvc.Logica;

public class RemoveContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		Long id = Long.parseLong(req.getParameter("id"));
		
		Connection conexao = (Connection) req.getAttribute("connection");
		ContatoDAO dao = new ContatoDAO(conexao);
		dao.remove(dao.getContatoById(id));
		
		//return "lista-contatos.jsp";
		return "mvc?logica=ListaContatosLogica";
		 
		
	}

}

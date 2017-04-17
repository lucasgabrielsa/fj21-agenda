package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.modelo.Contato;
import br.com.caelum.mvc.Logica;

public class FormAlteraContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Long id = Long.parseLong(req.getParameter("id"));
		
		Connection conexao = (Connection) req.getAttribute("connection");
		ContatoDAO dao = new ContatoDAO(conexao);
		Contato contato = dao.getContatoById(id);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = sdf.format(contato.getDataNascimento().getTime());
		
		req.setAttribute("contato", contato);
		req.setAttribute("dataFormatada", dataFormatada);
		
		
		
		return "/WEB-INF/jsp/adiciona-contato.jsp";																																																																																																																																																																																																																																																																																																						
	}

}

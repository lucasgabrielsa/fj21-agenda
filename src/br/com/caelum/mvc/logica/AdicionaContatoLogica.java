package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.modelo.Contato;
import br.com.caelum.mvc.Logica;

public class AdicionaContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Contato contato = new Contato();
		
		Connection conexao = (Connection) req.getAttribute("connection");
		ContatoDAO dao = new ContatoDAO(conexao);
		
		String id = req.getParameter("id");
			
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setEndereco(req.getParameter("endereco"));
		try {
			String dataTexto = req.getParameter("dataNascimento");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyyy");
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(sdf.parse(dataTexto));

			contato.setDataNascimento(dataNascimento);
			
			dao.adiciona(contato);
		} catch (ParseException e) {
			throw new Exception("erro na conversão da data");			
		}
		
				
		if(id != "") {
			//update
			Long idContato = Long.parseLong(id);
			contato.setId(idContato);
			dao.update(contato);
		}
		else {			
			//insert
			dao.adiciona(contato);
		}		
		
		
		return "mvc?logica=ListaContatosLogica";
		
	}

}

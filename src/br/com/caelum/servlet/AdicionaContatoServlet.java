package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();

		Contato contato = new Contato();
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setEndereco(req.getParameter("endereco"));
		try {
			String dataTexto = req.getParameter("dataNascimento");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyyy");
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(sdf.parse(dataTexto));

			contato.setDataNascimento(dataNascimento);
		} catch (ParseException e) {
			out.println("erro na conversão da data");
			return;
		}

		new ContatoDAO().adiciona(contato);

		// imprime o nome do contato que foi adicionado
		out.println("<html>");
		out.println("<body>");
		out.println("Contato " + contato.getNome() + " adicionado com sucesso");
		out.println("</body>");
		out.println("</html>");

	}

}

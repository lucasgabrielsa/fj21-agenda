package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contador")
public class ContadorServlet extends HttpServlet {
	
	private int contador = 0; //variavel de instância
	
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet Contador iniciada!");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				
		 // recebe o writer
        PrintWriter out = res.getWriter();
        
        this.contador++;

        // escreve o texto
        out.println("<html>");
        out.println("<body>");
        out.println("Contador agora é igual: " + contador);
        out.println("</body>");
        out.println("</html>");
        
       
		
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet Contador destruida!");
	}

}

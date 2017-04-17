<%@ page import="br.com.caelum.jdbc.ConnectionFactory, br.com.caelum.dao.ContatoDAO, br.com.caelum.modelo.Contato,
	 java.util.List, java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.4.0/css/bulma.css" />
<title>Listando Contatos</title>
</head>
<body>
  <div class="container">
  <table class="table">
  <thead>
    <tr>     
   	  <th><abbr title="Id">Id</abbr></th>
      <th>Nome</th>
      <th><abbr title="Email">Email</abbr></th>
      <th><abbr title="Endereço">Endereço</abbr></th>
      <th><abbr title="Data Nascimento">Data Nascimento</abbr></th>             
    </tr>
  </thead> 
  <tbody>
  <%
	ContatoDAO dao = new ContatoDAO();
	List<Contato> contatos = dao.getContatos();
	for(Contato contato : contatos)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = sdf.format(contato.getDataNascimento().getTime());   
%>
    <tr>     
      	<th><%=contato.getId() %></th>
    	<td><%=contato.getNome() %></td> 
   	 	<td><%=contato.getEmail() %></td>
        <td><%=contato.getEndereco() %></td>
        <td><%=dataFormatada %></td>       
    </tr>
    <%
	}
	%>   
  </tbody>
</table>
	
	</div>
</body>
</html>
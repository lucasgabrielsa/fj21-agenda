<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="br.com.caelum.jdbc.ConnectionFactory, br.com.caelum.dao.ContatoDAO, br.com.caelum.modelo.Contato,
	 java.util.List, java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.4.0/css/bulma.css" />
<style>
.container {
	margin-top: 30px;
}
</style>
<title>Listando Contatos</title>
</head>
<body>
  <div class="container">
  <c:import url="cabecalho.jsp"/>
  <table class="table">
  <thead>
    <tr>     
   	  <th><abbr title="Id">Id</abbr></th>
      <th>Nome</th>
      <th><abbr title="Email">Email</abbr></th>
      <th><abbr title="Endereço">Endereço</abbr></th>
      <th><abbr title="Data Nascimento">Data Nascimento</abbr></th>
      <th><abbr title=""></abbr></th>
      <th><abbr title=""></abbr></th>                     
    </tr>
  </thead> 
  <tbody>
  <!-- nao preciso mais do bean pq estou enviando pela servlet lista contatos -->
  <!--<jsp:useBean id="dao" class="br.com.caelum.dao.ContatoDAO"/>-->
	<c:forEach var="contato" items="${contatos}">
    <tr>     
      	<th>${contato.id}</th>
    	<td>${contato.nome}</td> 
   	 	<td>
   	 		<c:choose>
 			 <c:when test="${not empty contato.email}">
   				 <a href="mailto:${contato.email}">${contato.email}</a>
 			 </c:when>
		     <c:otherwise>
   				 E-mail não informado
  			 </c:otherwise>
			</c:choose>   	 	
   	 	</td>
        <td>${contato.endereco}</td>
        <td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
        <td>
	        <a href="mvc?logica=RemoveContatoLogica&id=${contato.id }" class="button is-danger">del</a>
		</td>  
		<td>
	        <a href="mvc?logica=FormAlteraContatoLogica&id=${contato.id }" class="button is-primary">edit</a>
		</td>        
    </tr>
    </c:forEach>       
  </tbody>
</table>
<a href="mvc?logica=NovoContatoLogica">Novo Contato</a>
	 <c:import url="rodape.jsp"/>
	</div>
</body>
</html>
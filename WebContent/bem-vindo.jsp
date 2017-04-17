<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bem Vindo</title>
</head>
<body>
	<% String msg = "Minha primeira página JSP"; %>	
	<h1><%=msg %></h1>
	
	<a href="adiciona-contato.html">Adicionar Contato</a><br />
	<a href="lista-contatos.jsp">Listando Contatos</a><br />
	<a href="digita-idade.jsp">Digita idade - testa passagem de parametros</a>
</body>
</html>
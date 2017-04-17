<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adiciona Contato</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.4.0/css/bulma.css" />

<link href="js/jquery-ui-1.12.1/jquery-ui.css" rel="stylesheet">
<script src="js/jquery-ui-1.12.1/external/jquery/jquery.js"></script>
<script src="js/jquery-ui-1.12.1/jquery-ui.js"></script>
<style>
.container {
	margin-top: 30px;
}
</style>
</head>
<body>
	<div class="container">
		<c:import url="cabecalho.jsp" />
		<form action="mvc?logica=AdicionaContatoLogica" method="post">
			<input type="hidden" name="id" value="${contato.id}"/>
			Nome: <input type="text" name="nome" class="input" value="${contato.nome}" /><br /> 
			E-mail: <input class="input" type="text" name="email" value="${contato.email }" /><br />
			Endereço: <input type="text" class="input"	name="endereco" value="${contato.endereco }" /><br />
			Data Nascimento:<caelum:campoData id="dataNascimento" value="${dataFormatada }"/><br /> 
			<input type="submit" value="Gravar" class="button is-primary" style="margin-top: 5px" />
		</form>
		<br /> <a href="mvc?logica=ListaContatosLogica">Lista dos Contatos</a>
		<c:import url="rodape.jsp" />
	</div>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css" />
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<div class="fadeIn first"></div>
			<h1 id="h1">Fazer cadastro</h1>
			<h5 id="erro">${msg}</h5>
			<form id="formCadastro" action="userServlet?action=cadastrar" method="post">
				<input type="text" id="txtNome" class="fadeIn second" name="txtNome" value="${user.nome}" placeholder="Nome">
				<input type="text" id="txtEmail" class="fadeIn second" name="txtEmail" value="${user.email}" placeholder="Email">
				<input type="text" id="txtTelefone" class="fadeIn second" name="txtTelefone" value="${user.telefone}" placeholder="Telefone">
				<input type="password" id="txtPassword1" class="fadeIn second" name="txtPassword1" value="${user.password}" placeholder="Senha">
				<input type="password" id="txtPassword2" class="fadeIn second" name="txtPassword2" value="${user.password}" placeholder="Confirme a senha">
				<input type="button" class="fadeIn fourth" value="Cadastrar" id="btnCadastrar" onclick="validar()">
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">	
	function validar() {
		var nome = document.getElementById("txtNome").value;
		var email = document.getElementById("txtEmail").value;
		var senha1 = document.getElementById("txtPassword1").value;
		var senha2 = document.getElementById("txtPassword2").value;

		if (nome == "") {
			alert("Digite um nome.");
		} else if (email == "") {
			alert("Digite um email.");
		} else if (senha1 == "") {
			alert("Digite uma senha.");
		} else if (senha2 == "") {
			alert("Confirme a senha.");
		} else if (senha1 != senha2) {
			alert("As senhas são diferentes.");
		} else {
			document.getElementById('formCadastro').submit();
		}
	}
</script>

</html>




































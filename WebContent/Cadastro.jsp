<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Pagina de Cadastro</h1>
	<form id="formCadastro" action="cadastroServlet" method="post">
		<table>
			<tr>
				<td><label>Nome:</label></td>
				<td><input type="text" name="txtNome" id="txtNome"></td>
			</tr>
			<tr>
				<td><label>Email:</label></td>
				<td><input type="text" name="txtEmail" id="txtEmail"></td>
			</tr>
			<tr>
				<td><label>Senha:</label></td>
				<td><input type="password" name="txtPassword1" id="txtPassword1"></td>
			</tr>
			<tr>
				<td><label>Senha:</label></td>
				<td><input type="password" name="txtPassword2" id="txtPassword2"></td>
			</tr>
			<tr>
				<td><input type="button" id="btnCadastrar" value="Cadastrar" onclick="validar()"></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	function validar() {
		var nome = document.getElementById("txtNome").value;
		var email = document.getElementById("txtEmail").value;
		var senha1 = document.getElementById("txtPassword1").value;
		var senha2 = document.getElementById("txtPassword2").value;
		
		if (nome == ""){
			alert("Digite um nome.");
		}
		else if (email == ""){
			alert("Digite um email.");
		}
		else if (senha1 == ""){
			alert("Digite uma senha.");
		}
		else if (senha2 == ""){
			alert("Confirme a senha.");
		}
		else if (senha1 != senha2){
			alert("As senhas são diferentes.");
		}
		else{
			document.getElementById('formCadastro').submit();
		}
	}
</script>

</html>




































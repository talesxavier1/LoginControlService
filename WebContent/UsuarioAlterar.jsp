<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link  rel="stylesheet" href="resources/css/mostrar.css">
	</head>
	<body>
		<div class="container">
			<form id="contact" action="userServlet?action=alterar" method="post">
				<h1 align="center">Alterar usuário</h1>
				<h5>${msg}</h5>
				<fieldset>
					<label>Id</label>
					<input type="text" name="txtId" id="txtId" value="${user.id}" readonly="readonly">
				</fieldset>
				<fieldset>
					<label>Nome</label>
					<input type="text" name="txtNome" id="txtNome" value="${user.nome}">
				</fieldset>
				<fieldset>
					<label>Email</label>
					<input type="text" name="txtEmail" id="txtEmail" value="${user.email}">
				</fieldset>
				<fieldset>
					<label>Telefone</label>
					<input type="text" name="txtTelefone" id="txtTelefone" value="${user.telefone}">
				</fieldset>
				<fieldset>
					<label>Senha</label>
					<input type="text" name="txtPassword1" id="txtPassword1" value="${user.password}">
				</fieldset>
				<fieldset>
				<table>
					<tr>
						<td><button name="button" type="submit" onclick="validar()">Alterar</button></td>
						<td><button name="submit" type="submit"onclick="document.getElementById('contact').action = 'userServlet?action=listarUsuarios'">Cancelar</button></td>
					</tr>
				</table>
				</fieldset>
			</form>
		</div>
	</body>
	<script type="text/javascript">
	function validar() {
		var nome = document.getElementById("txtNome").value;
		var email = document.getElementById("txtEmail").value;
		var senha1 = document.getElementById("txtPassword1").value;
		
		if (nome == ""){
			alert("Digite um nome.");
		}
		else if (email == ""){
			alert("Digite um email.");
		}
		else if (senha1 == ""){
			alert("Digite uma senha.");
		}
		else{
			document.getElementById('contact').submit();
		}
	}
</script>
</html>
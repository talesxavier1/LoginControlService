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
		<form id="contact" action="ProdutoServlet?action=Alterar" method="post">
			<h3>Alterar Produto</h3>
			<h4>${msg}</h4>
			<fieldset>
				<label>Id</label>
				<input placeholder="Id" type="text" tabindex="1" required autofocus name="txtId" id="txtId" value="${user.id}" readonly="readonly">
			</fieldset>
			<fieldset>
				<label>Nome</label>
				<input placeholder="Nome" type="text" tabindex="2" id="txtNome" name="txtNome" value="${user.nome}" >
			</fieldset>
			<fieldset>
				<label>Quantidade</label>
				<input placeholder="Quantidade" type="tel"
					tabindex="3" required name="txtQuantidade" id="txtQuantidade" value="${user.quantidade}" >
			</fieldset>
			<fieldset>
				<label>Valor R$:</label>
				<input placeholder="Valor" type="text" tabindex="4" required  name="txtValor" id="txtValor" value="${user.valor}">
			</fieldset>
			<fieldset>
				<table>
					<tr>
						<td><button name="submit" type="submit">Alterar</button></td>
						<td><button name="submit" type="submit" onclick="document.getElementById('contact').action = 'ProdutoServlet?action=listarProdutos'">Cancelar</button></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>
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
			<form id="contact"  action="ProdutoServlet?action=Cadastrar" method="post">
				<h3>Cadastrar</h3>
				<h4>${msg}</h4>
				<fieldset>
					<label>Nome</label> 
					<input type="text" id="txtNome" name="txtNome" value="${produto.nome}">
				</fieldset>
				<fieldset>
					<label>Quantidade</label> 
					<input type="text" name="txtQuantidade" id="txtQuantidade" value="${produto.quantidade}">
				</fieldset>
				<fieldset>
					<label>Valor R$:</label>
					<input type="text" name="txtValor" id="txtValor" value="${produto.valor}">
				</fieldset>
				<fieldset>
					<table>
						<tr>
							<td><button name="submit" type="submit">Cadastrar</button></td>
							<td><button name="submit" type="submit" onclick="document.getElementById('contact').action = 'ProdutoServlet?action=listarProdutos'">Cancelar</button></td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
</body>
</html>
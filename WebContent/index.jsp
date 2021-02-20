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
		<form action="loginServlet" method="post" id="f">
			<table>
				<tr>
					<td><label>Email:</label></td>
					<td><input type="text" name="txtEmail" id="txtEmail"></td>
				</tr>
				<tr>
					<td><label>Senha:</label></td>
					<td><input type="text" name="txtPassword" id="txtPassword"></td>
				</tr>
				<tr>
					<td><input type="submit" name="btnEntrar" value="Login"></td>
					<td><input type="button" name="btnCadastrar" value="Cadastrar" onclick="goToCadastro()"></td>
			</table>
		</form>
	</body>
	<script type="text/javascript">
		function goToCadastro() {
			location.href="Cadastro.jsp"
		}
	</script>
</html>














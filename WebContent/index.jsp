<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link  rel="stylesheet" href="resources/css/estilo.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<div class="fadeIn first">
			</div>
			<h1 id="h1">Fazer login</h1>
			<h5 id="erro">${msg}</h5>
			<form action="loginServlet" method="post" >
				<input type="text" id="login" class="fadeIn second" name="txtEmail" placeholder="login">
				<input type="text" id="password" class="fadeIn third" name="txtPassword" placeholder="password">
				<input type="submit" class="fadeIn fourth" value="Log In">
			</form>
			<div id="formFooter">
				<a class="underlineHover" href="UsuarioCadastro.jsp">Cadastrar</a>
			</div>
		</div>
	</div>
</body>
</html>














<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@page import="com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Acesso liberado.</h1>
		<br>
		<% session.setAttribute("userName", request.getAttribute("user_name")); %>
		<h3> Bem vindo ${userName} </h3>
		<a href="userServlet?action=listarUsuarios" ><img src="resources/img/ListaDeUsuarios.png" width="50" height="50" title="Listar usuários"></a>
		<a href="ProdutoServlet?action=listarProdutos" ><img src="resources/img/Produtos.png" width="50" height="50" title="Listar Produtos"></a>
		
		<br>
	</body>
</html>

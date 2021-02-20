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
		<h3> Bem vindo  <%=request.getAttribute("user_name") %> </h3>
	</body>
</html>

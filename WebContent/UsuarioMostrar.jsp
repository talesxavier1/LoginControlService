<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link  rel="stylesheet" href="resources/css/table.css">
	</head>
	
	<body>
		<div class="table-title">
			<h3>Usuários</h3>
		</div>
		<div class="box" >
			<a href="AcessoLiberado.jsp" id="novo"><img alt="Cadastrar" src="resources/img/Voltar.png" width="30" height="30" title="Voltar"></a>
			<table class="table-fill">
				<thead>
					<tr>
						<th class="text-left">Id</th>
						<th class="text-left">Nome</th>
						<th class="text-left">Email</th>
						<th class="text-left">Telefone</th>
						<th class="text-left">Delete</th>
						<th class="text-left">Alterar</th>
					</tr>
				</thead>
				<tbody class="table-hover">
					<jstl:forEach items="${usersList}" var="user">
							<tr>
								<td class="text-left"><jstl:out value="${user.id}"></jstl:out></td>
								<td class="text-left"><jstl:out value="${user.nome}"></jstl:out></td>
								<td class="text-left"><jstl:out value="${user.email}"></jstl:out></td>
								<td class="text-left"><jstl:out value="${user.telefone}"></jstl:out></td>
								<td><a style="align-self: center" href="userServlet?action=excluir&userId=${user.id}"><img alt="Excluir" title="Excluir" src="resources/img/excluir.png" height="30" width="30"></a></td>
								<td><a href="userServlet?action=alterar&userId=${user.id}"><img alt="Alterar" title="Editar" src="resources/img/editar.png" height="30" width="30"></a></td>
							</tr>
					</jstl:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>
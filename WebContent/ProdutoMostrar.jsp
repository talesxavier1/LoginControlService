<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/table.css">
<style type="text/css">
.teste{

   position: relative;
   top: 20px;
   left: 45px;
}

</style>

</head>
<body>
	<div class="box" >
		<a href="ProdutoCadastrar.jsp" id="novo"><img alt="Cadastrar" src="resources/img/AdicionarProsuto.png" width="30" height="30" title="Cadastrar"></a>
		<a href="AcessoLiberado.jsp" id="novo"><img alt="Cadastrar" src="resources/img/Voltar.png" width="30" height="30" title="Voltar"></a>
			<table class="table-fill">
				<thead>
					<tr>
						<th class="text-left">Id</th>
						<th class="text-left">Produto</th>
						<th class="text-left">Quantidade</th>
						<th class="text-left">Valor  </th>
						<th class="text-left">Excluir</th>
						<th class="text-left">Alterar</th>
					</tr>
				</thead>
				<tbody>
					<jstl:forEach items="${ListaProduto}" var="produto">
						<tr>
							<td><jstl:out value="${produto.id}"/></td>
							<td><jstl:out value="${produto.nome}"/></td>
							<td><jstl:out value="${produto.quantidade}"/></td>
							<td><jstl:out value="R$ ${produto.valor}"/></td>
							<td><a href="ProdutoServlet?action=excluir&produtoId=${produto.id}"><img alt="Excluir" src="resources/img/excluir.png" width="30" height="30" title="Deletar"></a></td>
							<td><a href="ProdutoServlet?action=Alterar&produtoId=${produto.id}"><img alt="Cadastrar" src="resources/img/editar.png" width="30" height="30" title="Alterar"></a></td>
						</tr>
					</jstl:forEach>
				</tbody>
			</table>
		</div>
</body>
</html>
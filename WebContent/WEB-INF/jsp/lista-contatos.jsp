<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>Lista Contatos</title>
</head>
<body>

<a href="mvc?logica=FormAdicionaContatoLogic">Incluir novo contato</a>

<h3>Lista</h3>
<hr/>

<table>
	<c:forEach var="contato" items="${contatos}">
		<tr>
			<td>${contato.nome}</td>
			<td>
				<c:choose>
					<c:when test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:when>
					<c:otherwise>
						E-mail não informado
					</c:otherwise>
				</c:choose>
			</td>
			<td>${contato.endereco}</td>
			<td>
				<fmt:formatDate value="${contato.datanascimento}" pattern="dd/MM/yyyy"/>
			</td>
			<td>
				<a href="mvc?logica=FormAlteraContatoLogic&id=${contato.id}">Alterar</a>
			</td>
			<td>
				<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}&nome=${contato.nome}">Remover</a>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Formulário de Contato</title>
</head>
<body>
	
	<h3>Altera Contato</h3>
	<hr/>
	<form action="mvc?logica=AlteraContatoLogic" method="POST">
		<input type="hidden" name="id" value="${contato.id}"/>
		Nome: <input type="text" name="nome" value="${contato.nome}"/><br/>
		E-mail: <input type="text" name="email" value="${contato.email}"/><br/>
		Endereço: <input type="text" name="endereco" value="${contato.endereco}"/><br/>
		Data Nascimento: <input type="text" name="datanascimento" value="<fmt:formatDate value="${contato.datanascimento}" pattern="dd/MM/yyyy"/>"><br/>
		
		<input type="submit" value="Gravar"/>
	</form>
	
	<p/>
	<a href="mvc?logica=ListaContatosLogic">Retornar a lista de Contatos</a>
	
</body>
</html>
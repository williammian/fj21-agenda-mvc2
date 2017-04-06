<html>
<head>
<title>Formulário de Contato</title>
</head>
<body>
	
	<h3>Adiciona Contato</h3>
	<hr/>
	<form action="mvc?logica=AdicionaContatoLogic" method="POST">
		Nome: <input type="text" name="nome"/><br/>
		E-mail: <input type="text" name="email"/><br/>
		Endereço: <input type="text" name="endereco"/><br/>
		
		Data Nascimento: <input type="text" name="datanascimento"/><br/>
		
		<input type="submit" value="Gravar"/>
	</form>
	
	<p/>
	<a href="mvc?logica=ListaContatosLogic">Retornar a lista de Contatos</a>
	
</body>
</html>
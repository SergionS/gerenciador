<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	FORM Empresa<br/>
	<form method="post" action="novaEmpresa">
		<label for="empresa">Nome</label><br/>
		<input  type="text" name="nome" id="empresa" /><br/>
		<br/>
		<input type="submit" value="Salvar" />
		
		
	</form>
	<hr>
	FORM Usuario<br/>
	<form method="post" action="novoUsuario">
		<label for="usuario">E-mail</label><br/>
		<input  type="text" name="email" id="usuario" /><br/>
		<input type="password" name="senha" />
		<br/>
		<input type="submit" value="Salvar" />
	</form>
	<hr>
	FORM login<br/>
	<form method="post" action="login">
		<label for="usuario">E-mail</label><br/>
		<input  type="text" name="email" id="usuario" /><br/>
		<input type="password" name="senha" />
		<br/>
		<input type="submit" value="Logar" />
	</form>
	<form method="post" action="logout">
		<input type="submit" value="Sair" />
	</form>
	<hr/>
	<%= request.getAttribute("mensagem") %>
	
</body>
</html>
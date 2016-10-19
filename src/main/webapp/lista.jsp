<%@page import="java.util.Collection"%>
<%@page import="br.edu.ifsc.gerenciador.dao.EmpresaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="br.edu.ifsc.gerenciador.model.Empresa" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Resultado da busca
	<ul>
		<%
		Collection<Empresa> empresas = (Collection<Empresa>) request.getAttribute("empresas");
		
		for( Empresa empresa : empresas ) { %>
			<li><%= empresa.getId()%>: <%=empresa.getNome() %></li>
		<%
		}
		%>
	</ul>
</body>
</html>
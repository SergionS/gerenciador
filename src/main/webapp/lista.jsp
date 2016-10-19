<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Resultado da busca:
	<ul>
		<c:forEach items="${empresas}" var="empresa" varStatus="status" >
			<li>${status.index} => ${empresa.id}: ${empresa.nome}</li>
		</c:forEach>
	</ul>
</body>
</html>
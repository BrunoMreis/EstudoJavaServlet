<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkEntradaServlet" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="${linkEntradaServlet }" method="post">
		Login:<input type="text" name="login" value="${empresa.nome}">
		Senha:<input type="password" name="senha" value="${empresa.data}">
		<input type="text" name="acao" value="Login" hidden="true">
		<input type="submit">
	</form>

</body>
</html>
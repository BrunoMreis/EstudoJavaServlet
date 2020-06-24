<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.alura.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkEntradaServlet" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulário</title>
</head>
<body>

<c:import url="logout-parcial.jsp"/>

	<form action="${linkEntradaServlet }" method="post">
		Nome:<input type="text" name="nome" value="${empresa.nome}">
		Data Abertura:<input type="text" name="data" value="${empresa.data}">
		<input type="text" name="id" value="${empresa.id}" hidden="true">
		<input type="text" name="acao" value="AlteraEmpresa" hidden="true">
		<input type="submit">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.gerenciador.alura.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Empresas</title>
</head>
<body>
	<h1>Lista de empresas:</h1>

	<ul>
		<c:forEach items="${empresas}" var="empresa">

			<li>
				${empresa.value.nome } ${empresa.value.data }
				<a href="/gerenciador/apagaEmpresa?id=${empresa.value.id }" id="id">excluir</a>
				<a href="/gerenciador/mostraEmpresa?id=${empresa.value.id }" id="id">editar</a>
			</li>
				
			
		</c:forEach>

	</ul>
</body>
</html>
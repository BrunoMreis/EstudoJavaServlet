<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formul�rio</title>
</head>
<body>
	<form action="/gerenciador/editaEmpresa" method="post">
		Nome:<input type="text" name="nome" value="${empresa.nome}"> 
		Data Abertura:<input type="text" name="data" value="${empresa.data}">
		<input type="text" name="id" value="${empresa.id}" hidden="true" >
		<input type="submit">
	</form>
</body>
</html>
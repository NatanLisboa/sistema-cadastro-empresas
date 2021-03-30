<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.gerenciador.servlet.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresas cadastradas</title>
</head>
<body>
	
	Lista de empresas: <br />
	
	<ul>
		<c:forEach items="${listaEmpresas}" var="empresa">
			<li> ${empresa.nome} </li>
		</c:forEach>
	</ul>

</body>
</html>
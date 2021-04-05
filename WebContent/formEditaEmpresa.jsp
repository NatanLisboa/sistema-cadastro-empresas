<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar empresa</title>
</head>
<body>	
	
	<form action="${linkEntradaServlet}" method="post">
		
		<input type="hidden" name="acao" value="EditarEmpresa"/>
		<input type="hidden" name="id" value="${empresa.id }"/>
		Nome: <input type="text" name="nome" value="${empresa.nome }"/>
		Data de abertura: <input type="text" name="dataAbertura" value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>"/>
		
		<input type="submit" />
		
	</form>
	
</body>
</html>
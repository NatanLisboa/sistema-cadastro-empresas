<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<c:url value="/novaEmpresa" var="linkPaginaNovaEmpresaCadastrada"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	
	<form action="${linkPaginaNovaEmpresaCadastrada}" method="post">
	
		Nome: <input type="text" name="nome"/>
		Data de abertura: <input type="text" name="dataAbertura"/>
		
		<input type="submit" />
		
	</form>
	
</body>
</html>
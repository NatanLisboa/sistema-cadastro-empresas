<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.gerenciador.modelo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="linkEntradaServlet"></c:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresas cadastradas</title>
</head>
<body>
	
	<c:if test="${not empty empresa }">
		Empresa ${empresa} cadastrada com sucesso!
	</c:if>
	
	Lista de empresas: <br />
	
	<ul>
		<c:forEach items="${listaEmpresas}" var="empresa">
			<li> ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
			<a href="${linkEntradaServlet}?acao=MostrarEmpresa&id=${empresa.id}">editar</a>
			<a href="${linkEntradaServlet}?acao=RemoverEmpresa&id=${empresa.id}">remover</a>
			 </li>
		</c:forEach>
	</ul>

</body>
</html>
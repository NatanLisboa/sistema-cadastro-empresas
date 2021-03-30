<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="br.com.gerenciador.servlet.Empresa"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresas cadastradas</title>
</head>
<body>
	Lista de empresas: <br />
	<%
		@SuppressWarnings("unchecked")
		List<Empresa> listaEmpresas = (List<Empresa>) request.getAttribute("listaEmpresas");
	
		System.out.println("Exibindo lista de empresas");
	%>
	<ul>
		<% 
		for (Empresa e : listaEmpresas) {
		%>
		<li> <%= e.getNome() %> </li>
		<%
		}
		%>
	</ul>
</body>
</html>
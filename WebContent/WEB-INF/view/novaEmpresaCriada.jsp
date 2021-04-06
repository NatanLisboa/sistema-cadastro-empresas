<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/listaEmpresas" var="linkPaginaListaEmpresas"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresa criada com sucesso!</title>
</head>
<body>
	
	<c:if test="${not empty empresa }">
		Empresa ${empresa} cadastrada com sucesso!
	</c:if>
	
	<c:if test="${empty empresa }">
		Nenhuma empresa foi cadastrada no momento!
	</c:if>
	
</body>
</html>
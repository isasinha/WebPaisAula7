<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Países</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">  
</head>

<body style="background-image:url('backgroundmundo.jpg')">
<c:import url="Menu.jsp"/>

<br>
    <fieldset>
        <legend style="color:white">Lista de países cadastrados:</legend>
		<br>
		<p style="color:white">

			<c:forEach var="pais" items="${lista}">

			    <strong>Id:</strong>${pais.id}
			    <strong> | Nome:</strong>${pais.nome}
			    <strong> | População:</strong>${pais.populacao}    
			    <strong> | Área:</strong>${pais.area}
			    <br>

			</c:forEach>
		</p>
	</fieldset>
</body>
</html>
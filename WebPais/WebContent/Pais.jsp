<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import = "base.Pais" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>País Cadastrado</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">  
</head>

<body style="background-image:url('backgroundmundo.jpg')">
<c:import url="Menu.jsp"/>

<br>
    <fieldset>
        <legend style="color:white">País Cadastrado com sucesso!</legend>
		<br>
		<p style="color:white">
 			 
 			<strong>Id: </strong>${pais.id}
 			<br>  
 			<br>
 			<strong>Nome: </strong>${pais.nome}
 			<br>
 			<br>  
 			<strong>População: </strong>${pais.populacao}
 			<br>
 			<br>  
 			<strong>Área: </strong>${pais.area}
 			<br> 
		</p>
	</fieldset>
</body>
</html>
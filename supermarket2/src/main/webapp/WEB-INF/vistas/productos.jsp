<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filtro de productos</title>
<link rel="stylesheet" href="css/productos.css" type="text/css">
</head>
<body>
<h2><a href="cuentos.html">Volver a home page</a></h2>

<div class="login-box">

<c:if test = "${sesion.iniciada==false}">
	<img src="images/prohibido.jpg">
</c:if>
<c:if test = "${sesion.iniciada==true}">


	<c:forEach var="cue" items="${cuentos}">
		<p>Título : ${cue.nombre}</p>
		<p>Edad : ${cue.edad}</p>
		<p>Autor : ${cue.autor}</p>
		<p>Editorial : ${cue.editorial}</p>
		<p>Sinopsis : ${cue.sinopsis}</p>
		<p>Tema : ${cue.tema}</p>
		<img width="200px" alt="" src="images/${cue.imagen}">
		<hr/>
	</c:forEach>
	
	
</c:if>

</div>

</body>
</html>
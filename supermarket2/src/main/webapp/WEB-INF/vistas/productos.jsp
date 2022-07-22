<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filtro de productos</title>
</head>
<body>
<c:if test = "${sesion.iniciada==false}">
	<img src="images/prohibido.jpg">
</c:if>
<c:if test = "${sesion.iniciada==true}">
	<h1>Filtro de productos: ${fil}</h1>
	
	<c:forEach var="pro" items="${productos}">
		<p>Nombre: ${pro.nombre}</p>
		<p>Cantidad por unidad: ${pro.medida}</p>
		<p>Precio unidad: ${pro.precio}</p>
		<p>Stock: ${pro.stock}</p>
		<hr/>
	</c:forEach>
</c:if>
<h2><a href="supermercado.html">Volver a home page</a></h2>
</body>
</html>
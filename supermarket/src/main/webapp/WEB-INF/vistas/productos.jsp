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
	<h1>Filtro de productos: ${fil}</h1>
	
	<c:forEach var="pro" items="${productos}">
		<p>Nombre: ${pro.nombre}</p>
		<p>Cantidad por unidad: ${pro.medida}</p>
		<p>Precio unidad: ${pro.precio}</p>
		<p>Stock: ${pro.stock}</p>
		<hr/>
	</c:forEach>

</body>
</html>
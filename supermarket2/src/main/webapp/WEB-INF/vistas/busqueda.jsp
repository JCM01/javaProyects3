<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Busqueda de productos por contenido del nombre</h1>
<c:if test = "${sesion.iniciada==true}">
	<form:form action="productos.html" method="get" modelAttribute="filtroproducto">
		<p>
			Introduce tu clave para la búsqueda:
			<form:input path="filtro"/>
		</p>

		<input type="submit" value="Enviar"/>
	</form:form>
</c:if>
<c:if test = "${sesion.iniciada==false}">
	<img src="images/prohibido.jpg">
</c:if>
<h2><a href="supermercado.html">Volver a home page</a></h2>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Supermercado</title>
</head>
<body>
	<h1>${mensaje1}</h1>
	<h1>${mensaje2}</h1>
	<c:if test = "${sesion.iniciada==true}">
         <p>Usuario: ${sesion.user}<p>
    </c:if>
    <c:if test = "${sesion.iniciada==false}">
        <form:form action="login.html" method="get" modelAttribute="login">
        <fieldset><legend>Inicia sesión:</legend>
			<label>Login:</label>
			<form:input path="user"/>
			<label>Password:</label>
			<form:input type="passord" path="password"/>
			<input type="submit" value="Enviar"/>
		</fieldset>
	</form:form>
	<br/>
    </c:if>
	<img src="images/supermercado.jpg">
	<p>
	<a href="buscaproductos.html">Consultar productos</a>
	</p>
	<h3><a href="cerrar.html">Cerrar Sesión</a></h3>
</body>
</html>

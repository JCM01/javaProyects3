<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Supermercado</title>
<link rel="stylesheet" href="css/superm.css" type="text/css">
</head>
<body>

<div class="login-box">
  <h2>Login</h2>
 <form:form action="login.html" method="get" modelAttribute="login">
 <!--mensajes borrados-->
	 <c:if test = "${sesion.iniciada==true}">
         <p>Has iniciado sesión como: ${sesion.user}<p>
    </c:if>
    <c:if test = "${sesion.iniciada==false}">
    <div class="user-box">
      <label>Login:</label>
			<form:input path="user"/>
    </div>
    <div class="user-box">
    <label>Password:</label>
			<form:input type="password" path="password"/>
    </div>
      </c:if>
    	<input type="submit" value="Enviar"/>
  </form:form>
   <!--<img src="images/supermercado.jpg">-->
	<p>
	<a href="buscaproductos.html">Consultar productos</a>
	</p>
	<p>
	<a href="registro.html">Registrarse</a>
	</p>
	<p>
    <a href="politica.html">Consultar Política de Privacidad</a>
    </p>
	<h3><a href="cerrar.html">Cerrar Sesión</a></h3>
</div>  
    
	
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
<link rel="stylesheet" href="css/registro.css" type="text/css">
</head>
<body>


<div class="login-box">
 <h1>Register</h1>
<form:form action="registroTotal.html" method="get" modelAttribute="registro">
    <div class="user-box">
     <label>Introduce tu Nombre:</label>
			<form:input path="nombre"/>		
    </div>
    
    
    <div class="user-box">
    <label>Introduce tus Apellidos :</label>
			<form:input path="apellidos"/>
    </div>
    
 
    
         <div class="user-box">
 	<label>Introduce tu Correo :</label>
			<form:input path="correo"/>
    </div>
    
     <div class="user-box">
     <label>Introduce tu Password :</label>
		<form:input path="password"/>
    </div>
    
    	<input type="submit" value="Enviar"/>
    

 	</form:form>
 	<h2><a href="cuentos.html">Volver a home page</a></h2>
</div>
		

	


	


</body>
</html>
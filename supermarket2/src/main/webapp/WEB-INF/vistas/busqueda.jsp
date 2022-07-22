<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Búsqueda Cuentos</title>
<link rel="stylesheet" href="css/registro.css" type="text/css">
</head>
<body>


<div class="login-box">



	<c:if test="${sesion.iniciada==true}">
		<div class="todosFormularios">
			<!--busquedaContenido-->
			
			<!--busquedaTitulo-->
			<div class="busqueda">
				<form:form action="productos2.html" method="get"
					modelAttribute="filtroproducto">
					<div class="title">Búsqueda por Tema</div>

					<div class="input-container ic1">
						<form:input id="firstname" class="input" type="text"
							placeholder=" " path="filtro" />

						<div class="cut"></div>
					</div>
					<input class="submit" type="submit" value="Buscar" />
				</form:form>
			</div>
			<!--busquedaEdad-->
			<div class="busqueda">
				<form:form action="productos3.html" method="get"
					modelAttribute="filtroCuentoEdad">	
					<div class="title">Búsqueda por edad</div>

					<div class="input-container ic1">
						<form:select id="firstname" class="input" path="filtro">
							<form:option value="1">1</form:option>
							<form:option value="2">2</form:option>
							<form:option value="3">3</form:option>
						</form:select>

						<div class="cut"></div>
					</div>
					<input class="submit" type="submit" value="Buscar" />
				</form:form>
			</div>
		</div>
	

	</c:if>
	<h2>
		<a href="cuentos.html">Volver a Home Page</a>
	</h2>
		</div>
	<c:if test="${sesion.iniciada==false}">
		<img src="images/prohibido.jpg">
	</c:if>
	<h2>
		<a href="cuentos.html">Volver a Home Page</a>
	</h2>
	
</body>
</html>
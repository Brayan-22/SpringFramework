<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	display: flex;
}
.errors {
	color: red;
}
</style>
<meta charset="UTF-8">
<title>Formulario de registro para alumnos</title>
</head>
<body>
	<form:form action="procesarFormulario" method="get"
		modelAttribute="alumno">
Nombre: <form:input path="nombre" />
		<br>
		<form:errors path="nombre" cssClass="errors"/>
		<br>
Apellido: <form:input path="apellido" />
		<br>
Edad:
		<form:input path="edad"/> 
		<form:errors path="edad" cssClass="errors"/>
<br>
Email: 
		<form:input path="email"/>
		<form:errors path="email" cssClass="errors"></form:errors>
<br>
Codigo Postal:		
		<form:input path="codigoPostal"/>
		<form:errors path="codigoPostal" cssClass="errors"></form:errors>
<br>
Asignaturas optativas: 
<br>
		<form:select path="optativa" multiple="true">
			<form:option value="Diseño" label="Diseño"></form:option>
			<form:option value="Matematicas" label="Matematicas"></form:option>
			<form:option value="Comercio" label="Comercio"></form:option>
			<form:option value="Danza" label="Danza"></form:option>
		</form:select>
<br><br>

		Barcelona: <form:radiobutton path="ciudadEstudios" value="Barcelona"/>
		Bogotá: <form:radiobutton path="ciudadEstudios" value="Bogotá"/>
		Sao Paulo: <form:radiobutton path="ciudadEstudios" value="Sao Paulo"/>
		Medellin: <form:radiobutton path="ciudadEstudios" value="Medellin"/>
		
<br><br>

		Inglés: <form:checkbox path="idiomas" value="Ingles"/>
		Francés: <form:checkbox path="idiomas" value="Frances"/>
		Portugues: <form:checkbox path="idiomas" value="Portugues"/>
		Aleman: <form:checkbox path="idiomas" value="Aleman"/>

<br><br>
		<input type="submit" value="Enviar">
	</form:form>
</body>
</html>
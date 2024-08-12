<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
El alumno con nombre <strong>${alumno.nombre }</strong> y apellido : ${alumno.apellido }
<br>
Email : <strong>${alumno.email }</strong>
<br>
Codigo postal: <strong>${alumno.codigoPostal }</strong>
<br>
La edad del alumno es: <strong>${alumno.edad }</strong>
<br>
Y la asignatura escogida es <strong>${alumno.optativa }</strong>
<br>
La ciudad donde estudiará es: <em>${alumno.ciudadEstudios }</em>
<br>
Los idiomas a estudiar del alumno son: <strong>${alumno.idiomas }</strong>
</body>
</html>
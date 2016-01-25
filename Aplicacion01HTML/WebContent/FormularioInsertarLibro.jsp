<?xml version="1.0" encoding="UTF-8"?>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
	<script type="text/javascript" src="js/validacion.js" ></script>
	<link rel="stylesheet" type="text/css" href="css/formato.css" />

	<title>Formulario Libro</title>
</head>
<body>
	<form action="InsertarLibro.do" onsubmit="return validacion();">
		<fieldset>
			<legend>Formulario alta libro</legend>
			
			<p><label for="isbn">ISBN:</label>
			<input id="isbn" type="text" name="isbn" /></p>
			
			<p><label for="titulo">Titulo:</label>
			<input id="titulo" type="text" name="titulo" /></p>
			
			<p><label for="categoria">Categoria:</label>
			<select name="categoria">
				<c:forEach var="categoria" items="${listaDeCategorias}">
					<option value="${categoria.id}">${categoria.descripcion}</option>
				</c:forEach>
			</select>
			</p>
			
			<p><input type="submit" value="Insertar"/></p>
		</fieldset>
	</form>
</body>
</html>
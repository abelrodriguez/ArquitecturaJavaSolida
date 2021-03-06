<?xml version="1.0" encoding="UTF-8"?>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">

<head>
	<script type="text/javascript" src="js/validacion.js" ></script>
	<link rel="stylesheet" type="text/css" href="css/formato.css" />

	<title>Formulario Edición Libro</title>
</head>
<body>
	<form id="formularioEdicion" action="ModificarLibro.do" onsubmit="return validacion();">
		<fieldset>
			<legend>Formulario edición libro</legend>
			
			<p><label for="isbn">ISBN:</label>
			<input id="isbn" type="text" name="isbn" value="${libro.isbn}"/></p>
			
			<p><label for="titulo">Titulo:</label>
			<input id="titulo" type="text" name="titulo"  value="${libro.titulo}"/></p>

			<p><label for="categoria">Categoria:</label>
			<select name="categoria">
				<c:forEach var="categoria" items="${listaDeCategorias}">
					<c:choose>
						<c:when test="${categoria.descripcion==categoria}">
							<option value="${categoria.id}" selected="selected">${categoria.descripcion}</option>
						</c:when>
						<c:otherwise>
							<option value="${categoria.id}">${categoria.descripcion}</option>
						</c:otherwise> 
					</c:choose>
				</c:forEach>
			</select>
			<br/>
			</p>
			<p><input type="submit" value="Salvar"/></p>
		</fieldset>
	</form>
</body>
</html>
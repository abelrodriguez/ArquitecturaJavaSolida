<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.arquitecturajavasolida.Libro" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Libros</title>
</head>
<body>

	<form name="filtro" action="FiltrarLibrosPorCategoria.do">
		<select name="categoria">
			<option value="seleccionar">Seleccionar</option>
			<c:forEach var="categoria" items="${listaDeCategorias}">
				<option value="${categoria}">${categoria}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Filtrar"/>
	</form>
	
	<br/>
		
	<c:forEach var="libro" items="${listaDeLibros}">
		${libro.isbn} | ${libro.titulo} | ${libro.categoria}
		<a href="BorrarLibro.do?isbn=${libro.isbn}">Borrar</a>
		<a href="FormularioEditarLibro.do?isbn=${libro.isbn}">Editar</a>
		<br/>
	</c:forEach>

	<a href="FormularioInsertarLibro.do">Insertar Libro</a>

</body>
</html>
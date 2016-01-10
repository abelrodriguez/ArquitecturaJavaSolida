<%@page import="com.mysql.jdbc.DatabaseMetaData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.arquitecturajavasolida.DataBaseHelper" %>
<%@ page import="java.util.List" %>
<%@ page import="com.arquitecturajavasolida.Libro" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Libros</title>
</head>
<body>

	<form name="filtro">
	<select name="categoria">
		<option value="seleccionar">Seleccionar</option>

	<%
		// Obtenemos los registros
		List<String> listaDeCategorias = null;
		listaDeCategorias = Libro.buscarTodasLasCategorias();
		
		// Cargamos los datos
		for(String categoria:listaDeCategorias) {
	%>
			<option value="<%=categoria %>"> <%=categoria %></option>
	<%	} 		%>
	
	</select>
	<input type="submit" value="Filtrar"/>
	</form>
	
	<br/>
		
	<%
		// Obtenemos los registros
		List<Libro> listaDeLibros=null;
		if (request.getParameter("categoria")==null || request.getParameter("categoria").equals("seleccionar")) {
			listaDeLibros=Libro.buscarTodos();	
		} else {
			listaDeLibros = Libro.buscarPorCategoria(request.getParameter("categoria"));
		}
		
		
		// Cargamos los datos
		for(Libro libro:listaDeLibros) { 
%>
			<%=libro.getisbn()%>
			<%=libro.getTitulo()%>
			<%=libro.getCategoria()%>
			<a href="BorrarLibro.jsp?isbn=<%=libro.getisbn()%>">Borrar</a>
			<a href="FormularioEditarLibro.jsp?isbn=<%=libro.getisbn()%>">Editar</a>
			<br/>
	<% 	} 
	%>

<a href="FormularioInsertarLibro.jsp">Insertar Libro</a>

</body>
</html>
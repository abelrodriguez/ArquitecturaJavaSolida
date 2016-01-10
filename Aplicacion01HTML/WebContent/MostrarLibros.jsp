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
	<br/>
		
	<%
		// Obtenemos los registros
		List<Libro> listaDeLibros=null;
		listaDeLibros=Libro.buscarTodos();
		
		// Cargamos los datos
		for(Libro libro:listaDeLibros) { 
%>
			<%=libro.getisbn()%>
			<%=libro.getTitulo()%>
			<%=libro.getCategoria()%>
			<br/>
	<% 	} 
	%>

<a href="FormularioInsertarLibro.jsp">Insertar Libro</a>

</body>
</html>
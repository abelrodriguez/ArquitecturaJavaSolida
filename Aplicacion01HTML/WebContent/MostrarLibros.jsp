<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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

	<form name="filtro">
	<select name="categoria">
		<option value="seleccionar">Seleccionar</option>

	<%
		// Obtenemos los registros
		@SuppressWarnings("unchecked")
		List<String> listaDeCategorias = (List<String>)request.getAttribute("listaDeCategorias");
		
		
	
		if (listaDeCategorias != null) {
			// Cargamos los datos
			for(String categoria:listaDeCategorias) {
				if (categoria.equals(request.getParameter("categoria"))) {
	%>
					<option value="<%=categoria %>" selected> <%=categoria %></option>
	<%
				} else { 
	%>
					<option value="<%=categoria %>"> <%=categoria %></option>
	<%
				}	
			} 	
		}
	%>
	
	</select>
	<input type="submit" value="Filtrar"/>
	</form>
	
	<br/>
		
	<%
		// Obtenemos los registros
		@SuppressWarnings("unchecked")
		List<Libro> listaDeLibros=(List<Libro>)request.getAttribute("listaDeLibros");
		
		if (listaDeLibros != null) {
			// Cargamos los datos
			for(Libro libro:listaDeLibros) { 
	%>
				<%=libro.getisbn()%>
				<%=libro.getTitulo()%>
				<%=libro.getCategoria()%>
				<a href="BorrarLibro.do?isbn=<%=libro.getisbn()%>">Borrar</a>
				<a href="FormularioEditarLibro.jsp?isbn=<%=libro.getisbn()%>">Editar</a>
				<br/>
	<% 		} 
		}
	%>

<a href="FormularioInsertarLibro.jsp">Insertar Libro</a>

</body>
</html>
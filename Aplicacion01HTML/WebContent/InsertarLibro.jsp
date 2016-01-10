<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--  IMPORT PARA JDBC -->
<%@ page import="com.arquitecturajavasolida.Libro" %>


<%
	//obtenemos parámetros
	String isbn = request.getParameter("isbn");
	String titulo = request.getParameter("titulo");
	String categoria = request.getParameter("categoria");
	
	//Realizamos la inserción
	Libro libro = new Libro(isbn, titulo, categoria);
	libro.insertar();
	
	// Redirigimos a la página principal	
	response.sendRedirect("MostrarLibros.jsp");
%>
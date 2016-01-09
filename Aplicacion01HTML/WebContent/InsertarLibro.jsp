<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--  IMPORT PARA JDBC -->
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>


<%
	//obtenemos parámetros
	String isbn = request.getParameter("isbn");
	String titulo = request.getParameter("titulo");
	String categoria = request.getParameter("categoria");
	
	Connection conexion = null;
	Statement sentencia = null;
	int filas=0;
	
	try {
		// Abrimos conexión con BBDD
		Class.forName("com.mysql.jdbc.Driver");
		conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/arquitecturajavasolida", "manager", "manager");
		
		// Realizamos el registro 
		sentencia = conexion.createStatement();
		String consultaSQL = "insert into libros (isbn, titulo, categoria) values ";
		consultaSQL += "('" + isbn + "','" + titulo + "','" + categoria + "')";
		
		System.out.println(consultaSQL);
		
		filas = sentencia.executeUpdate( consultaSQL );
		
		// Redirigimos a la página principal	
		response.sendRedirect("MostrarLibros.jsp");
		
	} catch (ClassNotFoundException e) {
		System.out.println("Error en la carga del driver" + e.getMessage());
	} catch (SQLException e) {
		System.out.println("Error accediendo a la BBDD" + e.getMessage());
	} finally {
	
		// Cerramos las conexiones
		if (sentencia != null) {
			try { sentencia.close(); }
			catch (SQLException e) { System.out.println("Error cerrando la sentencia" + e.getMessage()); }
		}
		if (conexion != null) {
			try{ conexion.close(); }
			catch (SQLException e) { System.out.println("Error cerrando la conexión" + e.getMessage()); }
		}
	}
%>
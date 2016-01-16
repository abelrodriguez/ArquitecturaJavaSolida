package com.arquitecturajavasolida;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher despachador;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		despachador = null;
		String direccion = request.getServletPath();
		
		System.out.println("ServletPath = " + direccion);
		
		if (direccion.equals("/MostrarLibros.do")) {
			
			
			List<Libro> listaDeLibros = Libro.buscarTodos();
			List<String> listaDeCategorias = Libro.buscarTodasLasCategorias();
			
			request.setAttribute("listaDeLibros", listaDeLibros);
			request.setAttribute("listaDeCategorias", listaDeCategorias);
			
			despachador = request.getRequestDispatcher("MostrarLibros.jsp");
			
			
			
		} else if (direccion.equals("/FormularioInsertarLibro.do")) {
			List<String> listaDeCategorias = null;
			listaDeCategorias = Libro.buscarTodasLasCategorias();
			
			request.setAttribute("listaDeCategorias", listaDeCategorias);
			despachador = request.getRequestDispatcher("FormularioInsertarLibro.jsp");
		
			
			
		} else if (direccion.equals("/FormularioEditarLibro.do")) {
			String isbn = request.getParameter("isbn");
			List<String> listaDeCategorias = Libro.buscarTodasLasCategorias();
			
			Libro libro = Libro.buscarPorClave(isbn);
			
			request.setAttribute("listaDeCategorias", listaDeCategorias);
			request.setAttribute("libro", libro);
			despachador = request.getRequestDispatcher("FormularioEditarLibro.jsp");

			
			
		} else if (direccion.equals("/InsertarLibro.do")) {
			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String categoria = request.getParameter("categoria");
			
			Libro libro = new Libro(isbn, titulo, categoria);
			libro.insertar();
			
			despachador = request.getRequestDispatcher("MostrarLibros.do");
			
			
			
		} else if (direccion.equals("/BorrarLibro.do")) {
			String isbn = request.getParameter("isbn");
			
			Libro libro = new Libro(isbn);
			libro.borrar();
			
			despachador = request.getRequestDispatcher("MostrarLibros.do");
			
			
		} else if (direccion.equals("/SalvarLibro.do")) {
			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String categoria = request.getParameter("categoria");
			
			Libro libro = new Libro(isbn, titulo, categoria);
			libro.salvar();
			
			despachador = request.getRequestDispatcher("MostrarLibros.do");

			
		
		} else {
			// Filtrar.do
			System.out.println("Filtrar");
			String categoria = request.getParameter("categoria");
			List<Libro> listaDeLibros = null;
			List<String> listaDeCategorias = Libro.buscarTodasLasCategorias();
			
			if (categoria == null || categoria.equals("seleccionar")) {
				listaDeLibros = Libro.buscarTodos();
			} else {
				listaDeLibros = Libro.buscarPorCategoria(categoria);
			}
			
			request.setAttribute("listaDeLibros", listaDeLibros);
			request.setAttribute("listaDeCategorias", listaDeCategorias);
			
			despachador = request.getRequestDispatcher("MostrarLibros.jsp");
		
			
		}
		
		despachador.forward(request, response);
	}

}

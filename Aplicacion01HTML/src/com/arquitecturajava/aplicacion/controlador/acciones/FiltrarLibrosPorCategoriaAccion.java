package com.arquitecturajava.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.dao.jpa.CategoriaDAOJPAImpl;
import com.arquitecturajava.aplicacion.dao.jpa.LibroDAOJPAImpl;

public class FiltrarLibrosPorCategoriaAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Filtrar");
		String categoria = request.getParameter("categoria");
		
		CategoriaDAOJPAImpl categoriaDAO = new CategoriaDAOJPAImpl();
		LibroDAOJPAImpl libroDAO = new LibroDAOJPAImpl();
		List<Libro> listaDeLibros = null;
		List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
		
		if (categoria == null || categoria.equals("seleccionar")) {
			listaDeLibros = libroDAO.buscarTodos();
		} else {
			Categoria categoriaseleccionada = categoriaDAO.buscarPorClave(Integer.parseInt(categoria));
			listaDeLibros = libroDAO.buscarPorCategoria(categoriaseleccionada);
		}
		
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		
		return "MostrarLibros.jsp";
		
		
	}

}

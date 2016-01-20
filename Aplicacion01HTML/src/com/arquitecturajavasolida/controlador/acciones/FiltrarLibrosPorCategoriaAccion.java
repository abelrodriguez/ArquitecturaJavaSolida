package com.arquitecturajavasolida.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajavasolida.Libro;

public class FiltrarLibrosPorCategoriaAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Filtrar");
		String categoria = request.getParameter("categoria");
		List<Libro> listaDeLibros = null;
		List<Libro> listaDeCategorias = Libro.buscarTodasLasCategorias();
		
		if (categoria == null || categoria.equals("seleccionar")) {
			listaDeLibros = Libro.buscarTodos();
		} else {
			listaDeLibros = Libro.buscarPorCategoria(categoria);
		}
		
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		
		return "MostrarLibros.jsp";
		
		
	}

}

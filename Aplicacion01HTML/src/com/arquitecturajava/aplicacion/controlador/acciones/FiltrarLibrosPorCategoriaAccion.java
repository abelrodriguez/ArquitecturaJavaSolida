package com.arquitecturajava.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;
import com.arquitecturajava.aplicacion.servicios.impl.ServicioLibrosImpl;

public class FiltrarLibrosPorCategoriaAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Filtrar");
		String categoria = request.getParameter("categoria");
		
		ServicioLibros servicioLibros = new ServicioLibrosImpl();
		List<Libro> listaDeLibros = null;
		List<Categoria> listaDeCategorias = servicioLibros.buscarCategoriasLibros();
		
		if (categoria == null || categoria.equals("seleccionar")) {
			listaDeLibros = servicioLibros.buscarTodosLosLibros();
		} else {
			Categoria categoriaseleccionada = servicioLibros.buscarCategoriaPorClave(Integer.parseInt(categoria));
			listaDeLibros = servicioLibros.buscarLibrosPorCategoria(categoriaseleccionada);
		}
		
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		
		return "MostrarLibros.jsp";
		
		
	}

}

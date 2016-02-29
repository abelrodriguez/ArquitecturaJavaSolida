package com.arquitecturajava.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;
import com.arquitecturajava.aplicacion.servicios.impl.ServicioLibrosImpl;

public class FormularioInsertarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		List<Categoria> listaDeCategorias = null;
		
		ServicioLibros servicioLibros = new ServicioLibrosImpl();
		listaDeCategorias = servicioLibros.buscarCategoriasLibros();
		
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		return "FormularioInsertarLibro.jsp";
	
	}

}

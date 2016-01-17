package com.arquitecturajavasolida.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajavasolida.controlador.acciones.Accion;

public class ControladorLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher despachador = null;
		String direccion = request.getServletPath();
		Accion accion = null;
		
		accion = Accion.getAccion(direccion.substring(1, direccion.length()-3));
		
		despachador = request.getRequestDispatcher(accion.ejecutar(request, response));
		despachador.forward(request, response);
	}

}

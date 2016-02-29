package com.arquitecturajava.aplicacion.servicios.impl;


import java.util.List;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.dao.CategoriaDAO;
import com.arquitecturajava.aplicacion.dao.DAOAbstractFactory;
import com.arquitecturajava.aplicacion.dao.DAOFactory;
import com.arquitecturajava.aplicacion.dao.LibroDAO;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;

public class ServicioLibrosImpl implements ServicioLibros {
	private LibroDAO libroDAO = null;
	private CategoriaDAO categoriaDAO = null;
	
	public ServicioLibrosImpl() {
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		libroDAO = factoria.getLibroDAO();
		categoriaDAO = factoria.getCategoriaDAO();
	}
	
	public void salvarLibro(Libro libro) {
		libroDAO.salvar(libro);
	}
	public void insertarLibro(Libro libro) {
		libroDAO.insertar(libro);
	}
	
	public void borrarLibro(Libro libro) {
		libroDAO.borrar(libro);
	}
	public List<Libro> buscarTodosLosLibros() {
		return libroDAO.buscarTodos();
	}
	public List<Categoria> buscarCategoriasLibros() {
		return categoriaDAO.buscarTodos();
	}
	public Libro buscarLibroPorClave(String isbn) {
		return libroDAO.buscarPorClave(isbn);
	}
	public Categoria buscarCategoriaPorClave(int id) {
		return categoriaDAO.buscarPorClave(id);
	}
	public List<Libro> buscarLibrosPorCategoria(Categoria categoria) {
		return libroDAO.buscarPorCategoria(categoria);
	}

}

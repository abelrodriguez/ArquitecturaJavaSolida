package com.arquitecturajava.aplicacion.servicios;

import java.util.List;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.bo.Categoria;

public interface ServicioLibros {
	public void insertarLibro(Libro libro);
	public void salvarLibro(Libro libro);
	public void borrarLibro(Libro libro);
	public List<Libro> buscarTodosLosLibros();
	public List<Categoria> buscarCategoriasLibros();
	public Libro buscarLibroPorClave(String isbn);
	public Categoria buscarCategoriaPorClave(int id);
	public List<Libro> buscarLibrosPorCategoria(Categoria categoria);
}

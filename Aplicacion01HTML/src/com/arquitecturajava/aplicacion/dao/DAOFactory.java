package com.arquitecturajava.aplicacion.dao;

public interface DAOFactory {
	public CategoriaDAO getCategoriaDAO();
	public LibroDAO getLibroDAO();
}

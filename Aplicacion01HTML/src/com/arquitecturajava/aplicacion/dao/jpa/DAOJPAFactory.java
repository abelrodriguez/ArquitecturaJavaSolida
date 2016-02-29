package com.arquitecturajava.aplicacion.dao.jpa;

import com.arquitecturajava.aplicacion.dao.CategoriaDAO;
import com.arquitecturajava.aplicacion.dao.DAOFactory;
import com.arquitecturajava.aplicacion.dao.LibroDAO;

public class DAOJPAFactory implements DAOFactory {
	public CategoriaDAO getCategoriaDAO() {
		return new CategoriaDAOJPAImpl();
	}
	
	public LibroDAO getLibroDAO() {
		return new LibroDAOJPAImpl();
	}
}

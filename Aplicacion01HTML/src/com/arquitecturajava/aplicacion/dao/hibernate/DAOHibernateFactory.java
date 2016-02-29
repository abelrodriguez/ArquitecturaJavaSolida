package com.arquitecturajava.aplicacion.dao.hibernate;

import com.arquitecturajava.aplicacion.dao.CategoriaDAO;
import com.arquitecturajava.aplicacion.dao.DAOFactory;
import com.arquitecturajava.aplicacion.dao.LibroDAO;

public class DAOHibernateFactory implements DAOFactory{
	public CategoriaDAO getCategoriaDAO() {
		return new CategoriaDAOHibernateImpl();
	}
	
	public LibroDAO getLibroDAO() {
		return new LibroDAOHibernateImpl();
	}
}

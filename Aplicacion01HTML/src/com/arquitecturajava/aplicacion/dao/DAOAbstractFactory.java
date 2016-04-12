package com.arquitecturajava.aplicacion.dao;

import com.arquitecturajava.aplicacion.dao.hibernate.DAOHibernateFactory;
import com.arquitecturajava.aplicacion.dao.jpa.DAOJPAFactory;

public abstract class DAOAbstractFactory {
	public static DAOFactory getInstance() {
		String tipo = "Hibernate";
		
		if (tipo.equals("Hibernate")) {
			return new DAOHibernateFactory();
		} else {
			return new DAOJPAFactory();
		}
	}
}

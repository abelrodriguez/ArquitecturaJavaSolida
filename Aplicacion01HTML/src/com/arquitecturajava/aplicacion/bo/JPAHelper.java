package com.arquitecturajava.aplicacion.bo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAHelper {
	
	private static final EntityManagerFactory emf = buildEntityManagerFactory();
	
	private static EntityManagerFactory buildEntityManagerFactory() {
		try {
			return Persistence.createEntityManagerFactory("arquitecturaJava");
		} catch (Throwable ex) {
			throw new RuntimeException("Error al crear la factoria de JPA. Error: " + ex.toString());
		}
	}
	
	public static EntityManagerFactory getJPAFactory() {
		return emf;
	}
}

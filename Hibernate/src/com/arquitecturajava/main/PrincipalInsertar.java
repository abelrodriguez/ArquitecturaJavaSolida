package com.arquitecturajava.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.arquitecturajava.aplicacion.bo.Libro;

public class PrincipalInsertar {

	public static void main(String[] args) {
		System.out.println("Insertar un libro");
		
		Session session = null;
		Transaction transaccion = null;
		
		try {
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			transaccion = session.beginTransaction();
			
			Libro libro = new Libro("1442", "Iniciacion a Java", "Programacion");
			
			session.saveOrUpdate(libro);
			transaccion.commit();
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			transaccion.rollback();
		} finally {
			session.close();
		}
		
		
	}

}

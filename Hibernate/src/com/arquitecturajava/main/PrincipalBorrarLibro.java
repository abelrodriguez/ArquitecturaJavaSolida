package com.arquitecturajava.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.arquitecturajava.aplicacion.bo.Libro;

public class PrincipalBorrarLibro {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaccion = null;
		String isbn = "1442";
		
		try {
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			transaccion = session.beginTransaction();
			
			Libro libro = (Libro) session.get(Libro.class, isbn);
			
			session.delete(libro);
			transaccion.commit();
			
		} catch(HibernateException e) {
			System.out.println(e.getMessage());
			transaccion.rollback();
		} finally {
			session.close();
		}

	}

}

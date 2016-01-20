package com.arquitecturajava.main;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.arquitecturajava.aplicacion.bo.Libro;

public class PrincipalBuscarLibro {

	public static void main(String[] args) {
		System.out.println("Buscar un libro a través de su ISBN");
		
		Session session = null;
		String isbn = "2850";
		
		try {
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			
			Libro libro = (Libro) session.get(Libro.class, isbn);
			
			if (libro != null) {
				System.out.println(libro.getisbn());
				System.out.println(libro.getTitulo());
				System.out.println(libro.getCategoria());
			} else {
				System.out.println("Libro con ISBN " + isbn + " no encontrado");
			}
			
		} catch(HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

	}

}

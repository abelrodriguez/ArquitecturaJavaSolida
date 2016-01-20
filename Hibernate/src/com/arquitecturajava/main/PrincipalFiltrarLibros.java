package com.arquitecturajava.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.arquitecturajava.aplicacion.bo.Libro;

public class PrincipalFiltrarLibros {

	public static void main(String[] args) {
		System.out.println("Filtramos los datos");
		
		Session session = null;
		String categoria = "Historia";
		
		try {
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			
			Query consulta = session.createQuery("from Libro libro where libro.categoria=:categoria");
			consulta.setString("categoria", categoria);
			
			@SuppressWarnings("unchecked")
			List<Libro> lista = consulta.list();
			
			for(Libro lib:lista) {
				System.out.println(lib.getisbn());
				System.out.println(lib.getTitulo());
				System.out.println(lib.getCategoria());
				System.out.println("--------------------");
			}
		} catch(HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

	}

}

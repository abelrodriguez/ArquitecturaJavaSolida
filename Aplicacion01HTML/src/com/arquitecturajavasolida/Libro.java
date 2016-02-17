package com.arquitecturajavasolida;

import java.util.List;

import javax.persistence.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name="libros")
public class Libro {
	
	@Id
	private String isbn;
	private String titulo;
	@ManyToOne
	@JoinColumn(name="categoria")
	private Categoria categoria;
	
	
	@Override
	public int hashCode() {
		return isbn.hashCode();
	}
	
	@Override
	public boolean equals (Object o) {
		String isbnLibro = ((Libro)o).getisbn();
		return isbnLibro.equals(isbn);
	}
	
	public String getisbn() {
		return isbn;
	}
	
	public void setisbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Libro(String isbn, String titulo, Categoria categoria) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;
	}
	
	public Libro() {
		super();
	}
	public Libro(String isbn) {
		super();
		this.isbn = isbn;
	}
	
	public void insertar() {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		session.beginTransaction();
		session.save(this);
		session.getTransaction().commit();
		
	}
	
	public void salvar() {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		session.beginTransaction();
		session.saveOrUpdate(this);
		session.getTransaction().commit();
	}
	
	public void borrar() {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		session.beginTransaction();
		session.delete(this);
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Libro> buscarTodos() {
		System.out.println("buscarTodos");
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		
		List<Libro> listaDeLibros = null;
		Session session = factoriaSession.openSession();
		listaDeLibros = session.createQuery(" from Libro libro left join fetch libro.categoria").list();
		
		session.close();
		
		return listaDeLibros;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Libro> buscarTodasLasCategorias() {
		System.out.println("buscarTodasLasCategorias");
		
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		String consulta = "select distinct libros.categoria as categoria from Libro libros";
		List<Libro> listaDeCategorias = session.createQuery(consulta).list();
		
		session.close();
		
		return listaDeCategorias;
	}
	
	public static Libro buscarPorClave(String isbn) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		Libro libro = (Libro) session.get(Libro.class, isbn);
		session.close();

		return libro;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Libro> buscarPorCategoria( String categoria) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		Query consulta = session.createQuery(" from Libro libro where libro.categoria=:categoria");
		consulta.setString("categoria", categoria);
		
		List<Libro> listaDeLibros = consulta.list();
		session.close();
		
		return listaDeLibros;
	}
	
}

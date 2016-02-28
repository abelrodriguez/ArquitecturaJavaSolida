package com.arquitecturajava.aplicacion.bo;

import java.util.List;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name="Categorias")
public class Categoria {
	@Id
	private int id;
	private String descripcion;
	@OneToMany
	@JoinColumn(name="categoria")
	private List<Libro> listaDeLibros;
	
	public Categoria() {
		super();
	}
	
	public Categoria(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals (Object o) {
		int categoriaId = ((Categoria)o).getId();
		return id == categoriaId;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Categoria> buscarTodos() {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		List<Categoria> listaDeCategorias = session.createQuery(" from Categoria categoria").list();
		session.close();
		
		return listaDeCategorias;
	}
	
	public List<Libro> getListaDeLibros() {
		return listaDeLibros;
	}
	
	public void setListaDeLibros(List<Libro> listaDeLibros) {
		this.listaDeLibros = listaDeLibros;
	}
}

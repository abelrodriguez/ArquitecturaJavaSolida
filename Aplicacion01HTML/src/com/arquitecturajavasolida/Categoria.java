package com.arquitecturajavasolida;

import java.util.List;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name="Categorias")
public class Categoria {
	@Id
	private String id;
	private String descripcion;
	@OneToMany
	@JoinColumn(name="categoria")
	private List<Libro> listaDeLibros;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals (Object o) {
		String categoriaId = ((Categoria)o).getId();
		return id.equals(categoriaId);
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

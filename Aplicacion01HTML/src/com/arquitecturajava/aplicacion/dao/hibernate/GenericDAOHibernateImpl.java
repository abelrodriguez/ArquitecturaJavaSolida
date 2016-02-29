package com.arquitecturajava.aplicacion.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.arquitecturajava.aplicacion.dao.GenericDAO;

public abstract class GenericDAOHibernateImpl<T, Id extends Serializable> 
		implements GenericDAO<T, Id> {
	
	private Class<T> claseDePersistencia;
	
	@SuppressWarnings("unchecked")
	public GenericDAOHibernateImpl() {
		this.claseDePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T buscarPorClave(Id id) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		T objeto = null;
		try {
			objeto = (T) session.get(claseDePersistencia, id);
			return objeto;
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> buscarTodos() {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		List<T> listaDeObjetos = session.createQuery( " FROM " + claseDePersistencia.getSimpleName() + " o").list();
		
		session.close();
		return listaDeObjetos;
	}
	
	public void borrar(T objeto) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		session.beginTransaction();
		session.delete(objeto);
		session.getTransaction().commit();
		
		session.close();
	}
	
	public void salvar(T objeto) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		session.beginTransaction();
		session.saveOrUpdate(objeto);
		session.getTransaction().commit();
		
		session.close();
	}
	
	public void insertar(T objeto) {
		
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		session.beginTransaction();
		session.save(objeto);
		session.getTransaction().commit();
		
		session.close();
	}
}

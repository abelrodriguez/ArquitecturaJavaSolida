package com.arquitecturajavasolida;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-22T17:45:29.424+0100")
@StaticMetamodel(Categoria.class)
public class Categoria_ {
	public static volatile SingularAttribute<Categoria, Integer> id;
	public static volatile SingularAttribute<Categoria, String> descripcion;
	public static volatile ListAttribute<Categoria, Libro> listaDeLibros;
}

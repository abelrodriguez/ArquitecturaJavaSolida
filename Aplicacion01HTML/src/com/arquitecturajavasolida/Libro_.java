package com.arquitecturajavasolida;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-22T17:45:29.452+0100")
@StaticMetamodel(Libro.class)
public class Libro_ {
	public static volatile SingularAttribute<Libro, String> isbn;
	public static volatile SingularAttribute<Libro, String> titulo;
	public static volatile SingularAttribute<Libro, Categoria> categoria;
}

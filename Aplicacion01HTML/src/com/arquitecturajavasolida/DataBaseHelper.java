package com.arquitecturajavasolida;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.lang.reflect.Method;;

public class DataBaseHelper<T> {
	private static final Logger log = LogManager.getLogger(DataBaseHelper.class.getPackage().getName());

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1/arquitecturajavasolida";
	private static final String USUARIO = "arquitecturajava";
	private static final String PASS = "arquitecturajava";
	
	public int modificarRegistro( String consultaSQL ) {
		Connection conexion = null;
		Statement sentencia = null;
		int filasAfectadas = 0;
		
		try {
			// Abrimos conexión con BBDD
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, PASS);
			
			// Realizamos el registro 
			sentencia = conexion.createStatement();
			filasAfectadas = sentencia.executeUpdate( consultaSQL );
			
			
		} catch (ClassNotFoundException e) {
			log.error("Error Driver: " + e.getMessage());
			throw new DataBaseException("Clase no encontrada", e);
			
		} catch (SQLException e) {
			log.error("Error SQL: " + e.getMessage());
			throw new DataBaseException("Error de SQL", e);
			
		} finally {
		
			// Cerramos las conexiones
			if (sentencia != null) {
				try { sentencia.close(); }
				catch (SQLException e) { }
			}
			if (conexion != null) {
				try{ conexion.close(); }
				catch (SQLException e) { }
			}
		}
		
		return filasAfectadas;	
	}
	
	@SuppressWarnings("unchecked")
	public List<T> seleccionarRegistros( String consultaSQL, Class<T> clase ) {
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet filas = null;
		List<T> listaDeObjetos=new ArrayList<T>();
		
		System.out.println(consultaSQL);
		try {
			// Abrimos conexión con BBDD
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, PASS);
			
			// Obtenemos los registros
			sentencia = conexion.createStatement();
			filas = sentencia.executeQuery( consultaSQL );
			
			while(filas.next()) {
				T objeto=(T) Class.forName(clase.getName()).newInstance();
				Method[] metodos=objeto.getClass().getDeclaredMethods();

				for (int i=0; i<metodos.length; i++) {
					
					if (metodos[i].getName().startsWith("set")) {
						metodos[i].invoke(objeto, filas.getString(metodos[i].getName().substring(3)));
					}
					
					if (objeto.getClass().getName().equals("java.lang.String")) {
						objeto=(T)filas.getString(1);
					}
				}
				
				listaDeObjetos.add(objeto);
			}
		
		} catch (ClassNotFoundException e) {
			System.out.println("Error clase: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error SQL: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error al seleccionar registros: " + e.getMessage());
		}
		finally {
			if (sentencia != null) {
				try { sentencia.close(); } catch (SQLException e) { System.out.println("Error al cerrar sentencia" + e.getMessage());}
			}
			if (conexion != null) {
				try { conexion.close(); } catch (SQLException e) { System.out.println("Error al cerrar conexion" + e.getMessage());}
			}
		}
		
		return listaDeObjetos;
	}
}

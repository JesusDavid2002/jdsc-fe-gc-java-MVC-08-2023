package models;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Modelo {
	
	private String bd = "jdbc:mysql://localhost:3306/";
	private String usuario = "root";
	private String contra = "root";
	private String url = "?useTimezone=true&serverTimezone=UTC";
	private Connection conexion = null;
	
	public void conectarBD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(bd + url, usuario, contra);
			System.out.println("Conexion establecida al servidor");
			
		} catch(SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con la base de datos.");
			System.out.println(ex);
		}
	}
	
	public void cerrarBD() {
		try {
			conexion.close();
			System.out.println("Conexion finalizada con el servidor");
		} catch(SQLException ex) {
			Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void crearDB(String nombre) {
		try {
			String Query = "CREATE DATABASE " + nombre;
			Statement st = conexion.createStatement();
			st.execute(Query);
			
			cerrarBD();
	    	conexion = DriverManager.getConnection(bd + nombre + url , usuario, contra);
			
			System.out.println("Se ha creado la base de datos " + nombre + " de forma exitosa.");
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void crearTabla(String bd, String nombre_tabla) {
		try {
			String QueryBD = "USE " + bd + ";";
			Statement stBD = conexion.createStatement();
			stBD.executeUpdate(QueryBD);
			
			if(nombre_tabla.equalsIgnoreCase("clientes")) {
				String Query = "CREATE TABLE " + nombre_tabla + ""
						+ "(ID INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(250) DEFAULT NULL, apellido VARCHAR(250) DEFAULT NULL,"
						+ "direccion VARCHAR(250) DEFAULT NULL, DNI INT(11) DEFAULT NULL, fecha DATE DEFAULT NULL)";
				Statement st = conexion.createStatement();
				st.execute(Query);
			} else if(nombre_tabla.equalsIgnoreCase("videos")) {
				String Query = "CREATE TABLE " + nombre_tabla + ""
						+ "(ID INT PRIMARY KEY AUTO_INCREMENT, titulo VARCHAR(250) DEFAULT NULL, director VARCHAR(250) DEFAULT NULL,"
						+ "cli_id INT(11) DEFAULT NULL, FOREIGN KEY (cli_id) REFERENCES clientes(ID) ON DELETE CASCADE ON UPDATE CASCADE)";
				Statement st = conexion.createStatement();
				st.execute(Query);
			}
			System.out.println("Tabla " + nombre_tabla + " se a creado correctamente");
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("No se ha podido crear la tabla correctamente.");
		}
	}
	
    public void insertarDatosClientes(String bd, String nombre_tabla, String nombre, String apellido, String direccion, String dni, String fecha) {
    	try {
    		String QueryBD = "USE " + bd + ";";
    		Statement stBD = conexion.createStatement();
    		stBD.execute(QueryBD);
    		
    		String Query = "INSERT INTO " + nombre_tabla + "(nombre, apellido, direccion, DNI, fecha) VALUE("
    				+ "\"" + nombre + "\", "
    				+ "\"" + apellido + "\", "
    				+ "\"" + direccion + "\", "
    				+ "\"" + dni + "\", "
    				+ "\"" + fecha + "\"); ";
    		Statement st = conexion.createStatement();
    		st.executeUpdate(Query);
    		
    		JOptionPane.showMessageDialog(null, "Datos almacenados correctamente");
    	} catch(SQLException ex) {
    		System.out.println(ex.getMessage());
    		System.out.println("Error en el almacenamiento.");
    	}
    }
    
    public void actualizarDatosClientes(String bd, String nombre_tabla, String nombre, String apellido, String direccion, String dni) {
    	try {
    		String QueryBD = "USE " + bd + ";";
    		Statement stBD = conexion.createStatement();
    		stBD.execute(QueryBD);
    		
    		String Query = "UPDATE " + nombre_tabla + " SET nombre=" + "\"" + nombre + "\", " + "apellido=" + "\"" + apellido + "\", "
    				+ "direccion=" + "\"" + direccion + "\" WHERE dni= "+ "\"" + dni + "\"";
    		Statement st = conexion.createStatement();
    		st.executeUpdate(Query);
    		
    		JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
    	} catch(SQLException ex) {
    		System.out.println(ex.getMessage());
    		System.out.println("Error en el almacenamiento.");
    	}
    }
    
    public void insertarDatosVideos(String bd, String nombre_tabla, String titulo, String director, String cli_id) {
    	try {
    		String QueryBD = "USE " + bd + ";";
    		Statement stBD = conexion.createStatement();
    		stBD.execute(QueryBD);
    		
    		String Query = "INSERT INTO " + nombre_tabla + "(titulo, director, cli_id) VALUE("
    				+ "\"" + titulo + "\", "
    				+ "\"" + director + "\", "
    				+ "\"" + cli_id + "\"); ";
    		Statement st = conexion.createStatement();
    		st.executeUpdate(Query);
    		
    		JOptionPane.showMessageDialog(null, "Datos almacenados correctamente");
    	} catch(SQLException ex) {
    		System.out.println(ex.getMessage());
    		System.out.println("Error en el almacenamiento.");
    	}
    }
    
    public void actualizarDatosVideos(String bd, String nombre_tabla, String nombre, String titulo, String director) {
    	try {
    		String QueryBD = "USE " + bd + ";";
    		Statement stBD = conexion.createStatement();
    		stBD.execute(QueryBD);
    		
    		String Query = "UPDATE " + nombre_tabla + " SET titulo=" + "\"" + titulo + "\", "
    				+ "director=" + "\"" + director + "\" WHERE nombre= "+ "\"" + nombre + "\"";
    		Statement st = conexion.createStatement();
    		st.executeUpdate(Query);
    		
    		JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
    	} catch(SQLException ex) {
    		System.out.println(ex.getMessage());
    		System.out.println("Error en el almacenamiento.");
    	}
    }
    
    public void getValues(String bd, String nombre_tabla) {
    	try {
    		String QueryBD = "USE " + bd + ";";
    		Statement stBD = conexion.createStatement();
    		stBD.execute(QueryBD);
    		
    		String Query = "SELECT * FROM " + nombre_tabla;
    		Statement st = conexion.createStatement();
    		java.sql.ResultSet resultados;
    		resultados = st.executeQuery(Query);
    		
    		if(nombre_tabla.equals("clientes")) {
    			while(resultados.next()) {
    				System.out.println("ID: " + resultados.getString("ID") + ", "
    								+ "Nombre: " + resultados.getString("nombre") + ", "
    								+ "Apellido: " + resultados.getString("apellido") + ". "
    								+ "Dirección: " + resultados.getString("direccion") + ", "
    								+ "DNI: " + resultados.getString("DNI") + ". "
    								+ "Fecha: " + resultados.getString("fecha") + ". ");
    			}
    			System.out.println("\n------------------------------------------------\n");
    			
    		} else if(nombre_tabla.equals("videos")) {
    			while(resultados.next()) {
        			System.out.println("ID: " + resultados.getString("ID") + ", "
        								+ "Titulo: " + resultados.getString("titulo") + ", "
        								+ "Director: " + resultados.getString("director") + ", "
        								+ "ID Cliente: " + resultados.getString("cli_id") + ". ");
    			}
    			System.out.println("\n------------------------------------------------\n");
    		}
    		
    	} catch(SQLException ex) {
    		System.out.println(ex.getMessage());
    		System.out.println("Error en la adquisición de datos.");
    	}
    }
        
    public void deleteDatos(String nombre_tabla, String dato) {
    	try {
    		if(nombre_tabla.equals("clientes")) {
    			String Query = "DELETE FROM " + nombre_tabla + " WHERE DNI = \"" + dato + "\"";
	    		Statement st = conexion.createStatement();
	    		st.executeUpdate(Query);
    		
    		} else if (nombre_tabla.equals("videos")) {
    			String Query = "DELETE FROM " + nombre_tabla + " WHERE titulo = \"" + dato + "\"";
	    		Statement st = conexion.createStatement();
	    		st.executeUpdate(Query);
	  
    		}
    		
    		JOptionPane.showMessageDialog(null, "Datos eliminados correctamente");
    	} catch(SQLException ex) {
    		System.out.println(ex.getMessage());
    		System.out.println("Error borrando el registro especificado.");
    	}
    }
    
}

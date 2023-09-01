package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class ModeloEj3 {
	
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
			
			if(nombre_tabla.equalsIgnoreCase("cientificos")) {
				String Query = "CREATE TABLE " + nombre_tabla + ""
						+ "(DNI VARCHAR(8) PRIMARY KEY, NomApels VARCHAR(255))";
				Statement st = conexion.createStatement();
				st.execute(Query);
			} else if(nombre_tabla.equalsIgnoreCase("proyectos")) {
				String Query = "CREATE TABLE " + nombre_tabla + ""
						+ "(ID CHAR(4) PRIMARY KEY, nombre VARCHAR(255), horas int)";
				Statement st = conexion.createStatement();
				st.execute(Query);
			} else if(nombre_tabla.equalsIgnoreCase("asignado_a")) {
				String Query = "CREATE TABLE " + nombre_tabla + ""
						+ "(ID_proyecto CHAR(4), DNI_cientifico VARCHAR(8), "
						+ "PRIMARY KEY (ID_proyecto, DNI_cientifico),"
						+ "FOREIGN KEY (ID_proyecto) REFERENCES proyectos(ID) ON DELETE CASCADE ON UPDATE CASCADE,"
						+ "FOREIGN KEY (DNI_cientifico) REFERENCES cientificos(DNI) ON DELETE CASCADE ON UPDATE CASCADE)";
				Statement st = conexion.createStatement();
				st.execute(Query);
			}
			System.out.println("Tabla " + nombre_tabla + " se a creado correctamente");
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("No se ha podido crear la tabla correctamente.");
		}
	}
	
    public void insertarDatosCientificos(String bd, String nombre_tabla, String DNI, String NomApels) {
    	try {
    		String QueryBD = "USE " + bd + ";";
    		Statement stBD = conexion.createStatement();
    		stBD.execute(QueryBD);
    		
    		String Query = "INSERT INTO " + nombre_tabla + "(DNI, NomApels) VALUE("
    				+ "\"" + DNI + "\", "
    				+ "\"" + NomApels + "\"); ";
    		Statement st = conexion.createStatement();
    		st.executeUpdate(Query);
    		
    		JOptionPane.showMessageDialog(null, "Datos almacenados correctamente");
    	} catch(SQLException ex) {
    		System.out.println(ex.getMessage());
    		System.out.println("Error en el almacenamiento.");
    	}
    }
    
    public void actualizarDatosCientificos(String bd, String nombre_tabla, String DNI, String NomApels) {
    	try {
    		String QueryBD = "USE " + bd + ";";
    		Statement stBD = conexion.createStatement();
    		stBD.execute(QueryBD);
    		
    		String Query = "UPDATE " + nombre_tabla + " SET NomApels=" + "\"" + NomApels + "\" WHERE DNI= "+ "\"" + DNI + "\"";
    		Statement st = conexion.createStatement();
    		st.executeUpdate(Query);
    		
    		JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
    	} catch(SQLException ex) {
    		System.out.println(ex.getMessage());
    		System.out.println("Error en el almacenamiento.");
    	}
    }
    
    public void insertarDatosProyectos(String bd, String nombre_tabla, String ID, String nombre, String horas) {
    	try {
    		String QueryBD = "USE " + bd + ";";
    		Statement stBD = conexion.createStatement();
    		stBD.execute(QueryBD);
    		
    		String Query = "INSERT INTO " + nombre_tabla + "(ID, nombre, horas) VALUE("
    				+ "\"" + ID + "\", "
    				+ "\"" + nombre + "\", "
    				+ "\"" + horas + "\"); ";
    		Statement st = conexion.createStatement();
    		st.executeUpdate(Query);
    		
    		JOptionPane.showMessageDialog(null, "Datos almacenados correctamente");
    	} catch(SQLException ex) {
    		System.out.println(ex.getMessage());
    		System.out.println("Error en el almacenamiento.");
    	}
    }
    
    public void actualizarDatosProyectos(String bd, String nombre_tabla, String ID, String nombre, String horas) {
    	try {
    		String QueryBD = "USE " + bd + ";";
    		Statement stBD = conexion.createStatement();
    		stBD.execute(QueryBD);
    		
    		String Query = "UPDATE " + nombre_tabla + " SET nombre=" + "\"" + nombre + "\", "
    				+ "horas=" + "\"" + horas + "\" WHERE ID= "+ "\"" + ID + "\"";
    		Statement st = conexion.createStatement();
    		st.executeUpdate(Query);
    		
    		JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
    	} catch(SQLException ex) {
    		System.out.println(ex.getMessage());
    		System.out.println("Error en el almacenamiento.");
    	}
    }
    
    public void insertarDatosAsignadoA(String bd, String nombre_tabla, String DNI_cientifico, String ID_proyecto) {
    	try {
    		String QueryBD = "USE " + bd + ";";
    		Statement stBD = conexion.createStatement();
    		stBD.execute(QueryBD);
    		
    		String Query = "INSERT INTO " + nombre_tabla + "(ID_proyecto, DNI_cientifico) VALUE("
    				+ "\"" + ID_proyecto + "\", "
    				+ "\"" + DNI_cientifico + "\"); ";
    		Statement st = conexion.createStatement();
    		st.executeUpdate(Query);
    		
    		JOptionPane.showMessageDialog(null, "Datos almacenados correctamente");
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
    		
    		if(nombre_tabla.equals("cientificos")) {
    			while(resultados.next()) {
    				System.out.println("DNI: " + resultados.getString("DNI") + ", "
    								+ "Nombre y apellidos: " + resultados.getString("NomApels") + ". ");
    			}
    			System.out.println("\n------------------------------------------------\n");
    			
    		} else if(nombre_tabla.equals("proyectos")) {
    			while(resultados.next()) {
        			System.out.println("ID: " + resultados.getString("ID") + ", "
        								+ "Nombre: " + resultados.getString("nombre") + ", "
        								+ "Horas: " + resultados.getString("horas") + ". ");
    			}
    			System.out.println("\n------------------------------------------------\n");
    		} else if(nombre_tabla.equals("asignado_a")) {
    			while(resultados.next()) {
        			System.out.println("ID del Proyecto: " + resultados.getString("ID_proyecto") + ", "
        								+ "DNI del Cientifico: " + resultados.getString("DNI_cientifico") + ". ");
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
    		if(nombre_tabla.equals("cientificos")) {
    			String Query = "DELETE FROM " + nombre_tabla + " WHERE DNI = \"" + dato + "\"";
	    		Statement st = conexion.createStatement();
	    		st.executeUpdate(Query);
    		
    		} else if (nombre_tabla.equals("proyectos")) {
    			String Query = "DELETE FROM " + nombre_tabla + " WHERE ID = \"" + dato + "\"";
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

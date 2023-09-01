package ejercicio1.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JFrame;

import ejercicio1.views.VistaEjercicio1;
import models.Modelo;

public class Controlador implements ActionListener{

	private Modelo modelo;
	private VistaEjercicio1 vista;
	private String bd = "ejercicio1";
	private String tabla = "clientes";
	private String usuario = "root";
	private String contra = "root";
	
	public Controlador(Modelo modelo, VistaEjercicio1 vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	public void iniciarVista() {
		vista.setTitle("Tienda de videos");
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setVisible(true);
		vista.setLocationRelativeTo(null);
		modelo.conectarBD();
		modelo.crearDB(bd);
		modelo.crearTabla(bd, tabla);
	
	
	this.vista.registrarse.addActionListener(new ActionListener() {
		@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			if(!"".equals(vista.textField.getText()) && !"".equals(vista.textField_1.getText())
			  && !"".equals(vista.textField_2.getText()) && !"".equals(vista.textField_3.getText())) {
				try {
					modelo.insertarDatosClientes(bd, "clientes", vista.textField.getText(), vista.textField_1.getText(), vista.textField_2.getText(), 
													vista.textField_3.getText(), LocalDate.now().toString());
					
					vista.textField.setText("");
					vista.textField_1.setText("");
					vista.textField_2.setText("");
					vista.textField_3.setText("");
				} catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}	
		}
	});
	
	this.vista.actualizar.addActionListener(new ActionListener() {
		@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			if(!"".equals(vista.textField_3.getText())) {
				
				try {
					modelo.actualizarDatosClientes(bd, tabla, vista.textField.getText(), vista.textField_1.getText(), vista.textField_2.getText(), 
							vista.textField_3.getText());
					
					vista.textField.setText("");
					vista.textField_1.setText("");
					vista.textField_2.setText("");
					vista.textField_3.setText("");
				} catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}	
		}
	});
	
	this.vista.eliminar.addActionListener(new ActionListener() {
		@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			if(!"".equals(vista.textField_3.getText())) {
				try {
					String dniCliente = vista.textField_3.getText();
					modelo.deleteDatos(tabla, dniCliente);
					
					vista.textField.setText("");
					vista.textField_1.setText("");
					vista.textField_2.setText("");
					vista.textField_3.setText("");
				} catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}	
		}
	});
	
	this.vista.listado.addActionListener(new ActionListener() {
		@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				try {
					modelo.getValues(bd, tabla);
				} catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
		}
	});
}	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}

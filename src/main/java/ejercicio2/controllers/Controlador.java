package ejercicio2.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JFrame;

import ejercicio1.views.VistaEjercicio1;
import ejercicio2.views.VistaEjercicio2;
import ejercicio2.views.VistaGlobal;
import models.Modelo;

public class Controlador {
	
	private Modelo modelo;
	private VistaEjercicio2 vistaej2;;
	private VistaEjercicio1 vistaej1;
	private VistaGlobal vistagl;
	
	private String bd = "ejercicio2";
	private String tabla = "clientes";
	private String tabla2 = "videos";
	private String usuario = "root";
	private String contra = "root";

	public Controlador(Modelo modelo, VistaGlobal vista, VistaEjercicio1 vista1, VistaEjercicio2 vista2) {
		this.modelo = modelo;
		this.vistagl = vista;
		this.vistaej1 = vista1;
		this.vistaej2 = vista2;
	}
	
	public void iniciarVista() {
		vistagl.setTitle("Tienda de videos");
		vistagl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vistagl.setVisible(true);
		vistagl.setLocationRelativeTo(null);
		modelo.conectarBD();
		modelo.crearDB(bd);
		modelo.crearTabla(bd, tabla);
		modelo.crearTabla(bd, tabla2);
		
		
		vistagl.btnClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vistagl.setVisible(false);
				vistaej1.setVisible(true);
			}
		});
		
		vistagl.btnVideos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vistagl.setVisible(false);
				vistaej2.setVisible(true);
			}
		});
		
		this.vistaej1.volver.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				vistaej1.setVisible(false);
				vistagl.setVisible(true);
			}
		});
		
		this.vistaej1.registrarse.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				if(!"".equals(vistaej1.textField.getText()) && !"".equals(vistaej1.textField_1.getText())
				  && !"".equals(vistaej1.textField_2.getText()) && !"".equals(vistaej1.textField_3.getText())) {
					try {
						modelo.insertarDatosClientes(bd, tabla, vistaej1.textField.getText(), vistaej1.textField_1.getText(), vistaej1.textField_2.getText(), 
								vistaej1.textField_3.getText(), LocalDate.now().toString());
						
						vistaej1.textField.setText("");
						vistaej1.textField_1.setText("");
						vistaej1.textField_2.setText("");
						vistaej1.textField_3.setText("");
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
				}	
			}
		});
		
		this.vistaej1.actualizar.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				if(!"".equals(vistaej1.textField_3.getText())) {
					
					try {
						modelo.actualizarDatosClientes(bd, tabla, vistaej1.textField.getText(), vistaej1.textField_1.getText(), vistaej1.textField_2.getText(), 
								vistaej1.textField_3.getText());
						
						vistaej1.textField.setText("");
						vistaej1.textField_1.setText("");
						vistaej1.textField_2.setText("");
						vistaej1.textField_3.setText("");
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
				}	
			}
		});
		
		this.vistaej1.eliminar.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				if(!"".equals(vistaej1.textField_3.getText())) {
					try {
						String dniCliente = vistaej1.textField_3.getText();
						modelo.deleteDatos(tabla, dniCliente);
						
						vistaej1.textField.setText("");
						vistaej1.textField_1.setText("");
						vistaej1.textField_2.setText("");
						vistaej1.textField_3.setText("");
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
				}	
			}
		});
		
		this.vistaej1.listado.addActionListener(new ActionListener() {
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
		
		
		this.vistaej2.volver.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				vistaej2.setVisible(false);
				vistagl.setVisible(true);
			}
		});
		
		this.vistaej2.registrarse.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				if(!"".equals(vistaej2.textField.getText()) && !"".equals(vistaej2.textField_1.getText())
				  && !"".equals(vistaej2.textField_2.getText())) {
					try {
						modelo.insertarDatosVideos(bd, tabla2, vistaej2.textField.getText(), vistaej2.textField_1.getText(), vistaej2.textField_2.getText());
						
						vistaej2.textField.setText("");
						vistaej2.textField_1.setText("");
						vistaej2.textField_2.setText("");
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
				}	
			}
		});
		
		this.vistaej2.actualizar.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				if(!"".equals(vistaej2.textField_2.getText())) {
					
					try {
						modelo.actualizarDatosVideos(bd, tabla2, vistaej2.textField.getText(), vistaej2.textField_1.getText(), vistaej2.textField_2.getText());
						
						vistaej2.textField.setText("");
						vistaej2.textField_1.setText("");
						vistaej2.textField_2.setText("");
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
				}	
			}
		});
		
		this.vistaej2.eliminar.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				if(!"".equals(vistaej2.textField.getText())) {
					try {
						String nombreVideo = vistaej2.textField.getText();
						modelo.deleteDatos(tabla2, nombreVideo);
						
						vistaej2.textField.setText("");
						vistaej2.textField_1.setText("");
						vistaej2.textField_2.setText("");
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
				}	
			}
		});
		
		this.vistaej2.listado.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
					try {
						modelo.getValues(bd, tabla2);
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
			}
		});
	}
}

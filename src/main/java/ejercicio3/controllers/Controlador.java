package ejercicio3.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JFrame;

import ejercicio3.views.VistaCientificos;
import ejercicio3.views.VistaProyecto;
import ejercicio3.views.VistaVinculos;
import ejercicio3.views.VistaGlobalEj3;
import models.ModeloEj3;

public class Controlador {
	
	private ModeloEj3 modelo;
	private VistaCientificos vistaC;
	private VistaProyecto vistaP;
	private VistaVinculos vistaV;
	private VistaGlobalEj3 vistagl;
	
	private String bd = "ejercicio3";
	private String tabla = "cientificos";
	private String tabla2 = "proyectos";
	private String tabla3 = "asignado_a";
	private String usuario = "root";
	private String contra = "root";

	public Controlador(ModeloEj3 modelo, VistaGlobalEj3 vista, VistaCientificos vistaC, VistaProyecto vistaP, VistaVinculos vistaV) {
		this.modelo = modelo;
		this.vistagl = vista;
		this.vistaC = vistaC;
		this.vistaP = vistaP;
		this.vistaV = vistaV;
	}
	
	public void iniciarVista() {
		vistagl.setTitle("Laboratorio");
		vistagl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vistagl.setVisible(true);
		vistagl.setLocationRelativeTo(null);
		modelo.conectarBD();
		modelo.crearDB(bd);
		modelo.crearTabla(bd, tabla);
		modelo.crearTabla(bd, tabla2);
		modelo.crearTabla(bd, tabla3);
		
		
		vistagl.btnProyectos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vistagl.setVisible(false);
				vistaP.setVisible(true);
			}
		});
		
		vistagl.btnCientificos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vistagl.setVisible(false);
				vistaC.setVisible(true);
			}
		});
		
		vistagl.btnVinculos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vistagl.setVisible(false);
				vistaV.setVisible(true);
			}
		});

		// Aqui iran los botones de vista CIENTIFICOS
		
		this.vistaC.volver.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				vistaC.setVisible(false);
				vistagl.setVisible(true);
			}
		});
		
		this.vistaC.registrarse.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				if(!"".equals(vistaC.textField.getText()) && !"".equals(vistaC.textField_1.getText())) {
					try {
						modelo.insertarDatosCientificos(bd, tabla, vistaC.textField.getText(), vistaC.textField_1.getText());
						
						vistaC.textField.setText("");
						vistaC.textField_1.setText("");
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
				}	
			}
		});
		
		this.vistaC.actualizar.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				if(!"".equals(vistaC.textField.getText())) {
					
					try {
						modelo.actualizarDatosCientificos(bd, tabla, vistaC.textField.getText(), vistaC.textField_1.getText());
						
						vistaC.textField.setText("");
						vistaC.textField_1.setText("");
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
				}	
			}
		});
		
		this.vistaC.eliminar.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				if(!"".equals(vistaC.textField.getText())) {
					try {
						String dniCientifico = vistaC.textField.getText();
						modelo.deleteDatos(tabla, dniCientifico);
						
						vistaC.textField.setText("");
						vistaC.textField_1.setText("");
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
				}	
			}
		});
		
		this.vistaC.listado.addActionListener(new ActionListener() {
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

		// Aqui iran los botones de vista PROYECTOS
		
		this.vistaP.volver.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				vistaP.setVisible(false);
				vistagl.setVisible(true);
			}
		});
		
		this.vistaP.registrarse.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				if(!"".equals(vistaP.textField.getText()) && !"".equals(vistaP.textField_1.getText())
				  && !"".equals(vistaP.textField_2.getText())) {
					try {
						modelo.insertarDatosProyectos(bd, tabla2, vistaP.textField.getText(), vistaP.textField_1.getText(), vistaP.textField_2.getText());
						
						vistaP.textField.setText("");
						vistaP.textField_1.setText("");
						vistaP.textField_2.setText("");
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
				}	
			}
		});
		
		this.vistaP.actualizar.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				if(!"".equals(vistaP.textField.getText())) {
					
					try {
						modelo.actualizarDatosProyectos(bd, tabla2, vistaP.textField.getText(), vistaP.textField_1.getText(), vistaP.textField_2.getText());
						
						vistaP.textField.setText("");
						vistaP.textField_1.setText("");
						vistaP.textField_2.setText("");
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
				}	
			}
		});
		
		this.vistaP.eliminar.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				if(!"".equals(vistaP.textField.getText())) {
					try {
						String ID_proyecto = vistaP.textField.getText();
						modelo.deleteDatos(tabla2, ID_proyecto);
						
						vistaP.textField.setText("");
						vistaP.textField_1.setText("");
						vistaP.textField_2.setText("");
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
				}	
			}
		});
		
		this.vistaP.listado.addActionListener(new ActionListener() {
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
		
		// Aqui iran los botones de vista VINCULOS
		
		this.vistaV.volver.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				vistaV.setVisible(false);
				vistagl.setVisible(true);
			}
		});
		
		this.vistaV.registrarse.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				if(!"".equals(vistaV.textField.getText()) && !"".equals(vistaV.textField_1.getText())) {
					try {
						modelo.insertarDatosAsignadoA(bd, tabla3, vistaV.textField.getText(), vistaV.textField_1.getText());
						
						vistaV.textField.setText("");
						vistaV.textField_1.setText("");
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
				}	
			}
		});
				
		this.vistaV.eliminar.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				if(!"".equals(vistaV.textField.getText()) && !"".equals(vistaV.textField_1.getText())) {
					try {
						String ID_proyecto = vistaV.textField_1.getText();
						modelo.deleteDatos(tabla3, ID_proyecto);
						
						vistaV.textField.setText("");
						vistaV.textField_1.setText("");
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
				} 
			}
		});
		
		this.vistaV.listado.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
					try {
						modelo.getValues(bd, tabla3);
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
			}
		});
	}

}

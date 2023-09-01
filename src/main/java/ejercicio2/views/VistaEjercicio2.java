package ejercicio2.views;

import java.awt.EventQueue;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VistaEjercicio2 extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JButton registrarse, actualizar, eliminar, listado, volver;
	
	/**
	 * Create the frame.
	 */
	public VistaEjercicio2() {
		setTitle("Registrar Videos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Titulo:");
		lblNewLabel.setBounds(126, 57, 41, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblApellidos = new JLabel("Director:");
		lblApellidos.setBounds(126, 88, 46, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblDireccin = new JLabel("ID del Cliente:");
		lblDireccin.setBounds(125, 119, 72, 14);
		contentPane.add(lblDireccin);
		
		textField = new JTextField();
		textField.setBounds(207, 54, 144, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(207, 85, 144, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(207, 116, 144, 20);
		contentPane.add(textField_2);
		
		registrarse = new JButton("Registrar");
		registrarse.setBounds(169, 253, 87, 23);
		contentPane.add(registrarse);
		
		eliminar = new JButton("Eliminar Video");
		eliminar.setBounds(385, 253, 105, 23);
		contentPane.add(eliminar);
		
		listado = new JButton("Obtener Listado");
		listado.setBounds(264, 253, 109, 23);
		contentPane.add(listado);
		
		actualizar = new JButton("Actualizar Video");
		actualizar.setBounds(41, 253, 115, 23);
		contentPane.add(actualizar);
		
		volver = new JButton("Volver");
		volver.setBounds(430, 314, 89, 23);
		contentPane.add(volver);
		
	}

}

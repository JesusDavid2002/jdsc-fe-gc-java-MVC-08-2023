package ejercicio3.views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VistaCientificos extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JButton registrarse, actualizar, eliminar, listado, volver;
	/**
	 * Create the frame.
	 */
	public VistaCientificos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI científico:");
		lblNewLabel.setBounds(126, 57, 72, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblApellidos = new JLabel("Nombre y apellidos:");
		lblApellidos.setBounds(126, 88, 105, 14);
		contentPane.add(lblApellidos);
		
		textField = new JTextField();
		textField.setBounds(241, 54, 144, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(241, 85, 144, 20);
		contentPane.add(textField_1);
		
		registrarse = new JButton("Registrar");
		registrarse.setBounds(169, 253, 87, 23);
		contentPane.add(registrarse);
		
		eliminar = new JButton("Eliminar Científico");
		eliminar.setBounds(385, 253, 115, 23);
		contentPane.add(eliminar);
		
		listado = new JButton("Obtener Listado");
		listado.setBounds(264, 253, 109, 23);
		contentPane.add(listado);
		
		actualizar = new JButton("Actualizar Científico");
		actualizar.setBounds(29, 253, 127, 23);
		contentPane.add(actualizar);
		
		volver = new JButton("Volver");
		volver.setBounds(454, 313, 89, 23);
		contentPane.add(volver);
		
	}

}

package ejercicio3.views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VistaVinculos extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JButton registrarse, eliminar, listado, volver;

	/**
	 * Create the frame.
	 */
	public VistaVinculos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI científico:");
		lblNewLabel.setBounds(126, 57, 72, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblApellidos = new JLabel("ID del Proyecto");
		lblApellidos.setBounds(126, 88, 105, 14);
		contentPane.add(lblApellidos);
		
		textField = new JTextField();
		textField.setBounds(241, 54, 144, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(241, 85, 144, 20);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		registrarse = new JButton("Registrar");
		registrarse.setBounds(232, 253, 87, 23);
		contentPane.add(registrarse);
		
		eliminar = new JButton("Eliminar");
		eliminar.setBounds(345, 253, 115, 23);
		contentPane.add(eliminar);
		
		listado = new JButton("Obtener Listado");
		listado.setBounds(89, 253, 109, 23);
		contentPane.add(listado);
				
		volver = new JButton("Volver");
		volver.setBounds(454, 313, 89, 23);
		contentPane.add(volver);
		
	}

}

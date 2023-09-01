package ejercicio3.views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VistaGlobalEj3 extends JFrame {

	private JPanel contentPane;
	public JButton btnProyectos, btnCientificos, btnVinculos;
	
	/**
	 * Create the frame.
	 */
	public VistaGlobalEj3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnProyectos = new JButton("Proyectos");
		btnProyectos.setBounds(71, 208, 89, 23);
		contentPane.add(btnProyectos);
		
		btnCientificos = new JButton("Científicos");
		btnCientificos.setBounds(338, 208, 89, 23);
		contentPane.add(btnCientificos);
		
		JLabel lblNewLabel = new JLabel("¿A donde deseas acceder?");
		lblNewLabel.setBounds(195, 122, 149, 14);
		contentPane.add(lblNewLabel);
		
		btnVinculos = new JButton("Vinculos");
		btnVinculos.setBounds(195, 208, 111, 23);
		contentPane.add(btnVinculos);
	}

}

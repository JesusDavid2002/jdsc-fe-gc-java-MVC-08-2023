package ejercicio2.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaGlobal extends JFrame {

	private JPanel contentPane;
	public JButton btnClientes, btnVideos;

	/**
	 * Create the frame.
	 */
	public VistaGlobal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnClientes = new JButton("Clientes");
		btnClientes.setBounds(113, 190, 89, 23);
		contentPane.add(btnClientes);
		
		btnVideos = new JButton("Videos");
		btnVideos.setBounds(316, 190, 89, 23);
		contentPane.add(btnVideos);
		
		JLabel lblNewLabel = new JLabel("¿A donde deseas acceder?");
		lblNewLabel.setBounds(174, 121, 149, 14);
		contentPane.add(lblNewLabel);
	}

}

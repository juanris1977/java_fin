package Presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.ClientesService;
import service.LibreriaServiceFactory;
import service.LibrosService;

public class Autenticar extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JTextField txtpass;
	private JTextField textField;
	private JLabel res;
	private JButton btnTemasCombo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Autenticar frame = new Autenticar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Autenticar() {
		ClientesService clientes = LibreriaServiceFactory.getClientesService();
		LibrosService libros = LibreriaServiceFactory.getLibrosService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(34, 24, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(34, 73, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(118, 21, 86, 20);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(118, 70, 86, 20);
		contentPane.add(txtpass);
		txtpass.setColumns(10);
		res = new JLabel("");
		res.setBounds(118, 178, 233, 14);

		
		JButton btnNewButton = new JButton("ver nombres de libros");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(clientes.comprobarLogin(txtusuario.getText(), txtpass.getText())) {
					//creamos la ventana de libros y le pasamos la lista de libros
					new VentanaLibros(libros.listaLibros());
				}else {
					JOptionPane.showMessageDialog(Autenticar.this, "Usuario no válido");
				}
				
			}
		});
				
		
		
		btnNewButton.setBounds(118, 124, 170, 31);
		contentPane.add(btnNewButton);
		

	
		

		contentPane.add(res);
		
		JButton btnlistastemas = new JButton("ver temas en texto");
		btnlistastemas.setBounds(118, 172, 170, 31);
		
		btnlistastemas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(clientes.comprobarLogin(txtusuario.getText(), txtpass.getText())) {
					//creamos la ventana de temas y hacemos el combobox
					new VentanaTemasTextArea(libros.listaTemas());
				}else {
					JOptionPane.showMessageDialog(Autenticar.this, "Usuario no válido");
				}
				
			}
		});
		contentPane.add(btnlistastemas);
		
		btnTemasCombo = new JButton("ver temas en combo");
		btnTemasCombo.setBounds(118, 213, 170, 31);
		
		btnTemasCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(clientes.comprobarLogin(txtusuario.getText(), txtpass.getText())) {
					//creamos la ventana de temas y hacemos el combobox
					new VentanaTemasCombo(libros.listaTemas());
				}else {
					JOptionPane.showMessageDialog(Autenticar.this, "Usuario no válido");
				}
				
			}
		});
		
		contentPane.add(btnTemasCombo);
	
	}
}

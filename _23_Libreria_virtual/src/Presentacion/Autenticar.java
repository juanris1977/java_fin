package Presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.LibrosService;
import service.LibrosServiceFactory;

public class Autenticar extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JTextField txtpass;
	private JTextField textField;
	private JLabel res;

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
		LibrosService service = LibrosServiceFactory.getLibrosService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		txtpass = new JTextField();
		txtpass.setBounds(118, 70, 86, 20);
		contentPane.add(txtpass);
		txtpass.setColumns(10);
		res = new JLabel("");
		res.setBounds(118, 178, 233, 14);

		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (!service.comprobarLogin(txtusuario.getText(), txtpass.getText())) {
					res.setText("Credenciales incorrectas");
				}else {
					res.setText("Credenciales correctas");					
				}
			}
		});
		btnNewButton.setBounds(118, 124, 89, 23);
		contentPane.add(btnNewButton);
		

	
		

		contentPane.add(res);
	
	}

}

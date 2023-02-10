package presentacion;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame {
	
	public Login () {
		
	
	
		super("Autentificacion");
		this.setBounds(200, 200, 600, 450);   // a 100 en horizontal , a 50 en vertical, ..., de ancho 700 y 500 de alto 		

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);   	//Configurar el botón de cierre de la ventana
		
		this.getContentPane().setBackground(Color.GRAY);  //Poner color a la ventana
		
		inicializarComponentes();  // Creamos objetos control
		
		this.setVisible(true);               //  hace la ventana visible
	}
		
	void inicializarComponentes () {
		//Anular el gestor de organización (Layout)
		this.setLayout(null);
		
		JButton bt = new JButton("Validar");  // Creaccion dle control
		bt.setBounds(240, 300, 100, 30);           //  propiedades del control		
		this.add(bt);  //añadir el control (en este caso un boton) a la ventana
		
		JLabel lb1 = new JLabel("Usuario");
		lb1.setBounds(100, 100, 50, 30);
		this.add(lb1);
		
		JLabel lb2 = new JLabel("Contraseña");
		lb2.setBounds(100, 200, 100, 30);
		this.add(lb2);
		
		JTextField t1 = new JTextField();
		t1.setBounds(200, 100, 200, 30);
		this.add(t1);
		
		JTextField t2 = new JTextField();
		t2.setBounds(200, 200, 200, 30);
		this.add(t2);
		
	}
		
	
}

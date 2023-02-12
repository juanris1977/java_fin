package presentacion;

import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MiVentana extends JFrame {
	public MiVentana () {
		
		
		super("Factorial");  // Le damos el título a través del constructor de la superclase
		
		// la posicion de una ventana, la marca el punto superior izquierdo, y su distancia al punto superior izquierdo del "monitor"
		// El tamaño lo determina la altura y anchura , todo ello en pixeles
		
		this.setBounds(1200, 200, 500, 500);   // a 100 en horizontal , a 50 en vertical, ..., de ancho 700 y 500 de alto 		

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);   	//Configurar el botón de cierre de la ventana
		
		this.getContentPane().setBackground(Color.LIGHT_GRAY);  //Poner color a la ventana
		
		inicializarComponentes();  // Creamos objetos control
		
		this.setVisible(true);               //  hace la ventana visible
	}
	
	public int factorial(int numero) {			
				  if (numero==0)
				    return 1;
				  else
				    return numero * factorial(numero-1);			
	}
	
	void inicializarComponentes () {
		//Anular el gestor de organización (Layout)
		this.setLayout(null);
		
		
		
		JLabel lb = new JLabel("Introduce un número:");
		lb.setBounds(30, 50, 200, 30);
		
		
		JTextField t1 = new JTextField();
		t1.setBounds(200, 50, 100, 30);
		this.add(t1);
		
		JButton bt = new JButton("Calcular Factorial");  // Creaccion dle control
		bt.setBounds(200, 150, 150, 30);           //  propiedades del control			
		
	
		
		
		
		JLabel res = new JLabel("");
		res.setBounds(50, 250, 200, 30);
		
	
			
		
		bt.addActionListener(e-> res.setText("El factorial de "+(t1.getText())+" es "+factorial(Integer.parseInt(t1.getText()))));   // Al pulsar en el boton, pone el texto a la etiqueta 
	//	bt.addMouseListener((MouseListener) this);   // Al pulsar en el boton, pone el texto a la etiqueta 
		
		
		
		this.add(bt);  //añadir el control (en este caso un boton) a la ventana
		this.add(t1); 
		this.add(lb);
		this.add(res);

	}

}

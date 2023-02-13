package presentacion;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.stream.IntStream;

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

		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);   	//Configurar el botón de cierre de la ventana
		
		this.getContentPane().setBackground(Color.LIGHT_GRAY);  //Poner color a la ventana
		
		inicializarComponentes();  // Creamos objetos control
		
		this.setVisible(true);               //  hace la ventana visible
	}
	
	 int factorial(int numero) {			
			/*	  if (numero==0)
				    return 1;
				  else
				    return numero * factorial(numero-1);		*/
		 return IntStream.rangeClosed(1, numero)
				         .reduce(1, (a,b) -> a*b);
	}
	
	void inicializarComponentes () {
		//Anular el gestor de organización (Layout)
		this.setLayout(null);
		
		
		
		JLabel lb = new JLabel("Introduce un número:");
		lb.setBounds(30, 50, 200, 30);
		
		
		JTextField t1 = new JTextField();
		t1.setBounds(200, 50, 20, 30);
		
		
		JButton bt = new JButton("Calcular Factorial");  // Creaccion dle control
		bt.setBounds(200, 150, 150, 30);           //  propiedades del control			
		
		JLabel res = new JLabel("");
		res.setBounds(50, 250, 200, 30);
			
		bt.addActionListener(e-> res.setText("El factorial de "+(t1.getText())+" es "+factorial(Integer.parseInt(t1.getText()))));   // Al pulsar en el boton, pone el texto a la etiqueta 
	
		
		//hacer que pregunte si realmente quieres cerrar la ventana al cerrarla, debemos implementar un metodo de window listener , lo haremos con una clase anonima
		
		this.addWindowListener(new WindowListener () {   // el new es el nombre de la interfaz a implementar

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				int op = JOptionPane.showConfirmDialog(MiVentana.this, "¿Desea salir?");
				if (op==JOptionPane.YES_OPTION) {
					MiVentana.this.dispose();
				}				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				Color color = new Color ((int)(Math.random()*256) , (int)(Math.random()*256) , (int)(Math.random()*256));
				MiVentana.this.getContentPane().setBackground(color);  // cambia el color de fondo a la ventana				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
		this.add(bt);  //añadir el control (en este caso un boton) a la ventana
		this.add(t1); 
		this.add(lb);
		this.add(res);

	}

}

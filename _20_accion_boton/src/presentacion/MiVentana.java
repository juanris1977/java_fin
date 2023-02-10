package presentacion;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MiVentana extends JFrame {
	public MiVentana () {
		
		
		super("Primera ventana");  // Le damos el título a través del constructor de la superclase
		
		// la posicion de una ventana, la marca el punto superior izquierdo, y su distancia al punto superior izquierdo del "monitor"
		// El tamaño lo determina la altura y anchura , todo ello en pixeles
		
		this.setBounds(100, 50, 700, 500);   // a 100 en horizontal , a 50 en vertical, ..., de ancho 700 y 500 de alto 		

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);   	//Configurar el botón de cierre de la ventana
		
		this.getContentPane().setBackground(Color.CYAN);  //Poner color a la ventana
		
		inicializarComponentes();  // Creamos objetos control
		
		this.setVisible(true);               //  hace la ventana visible
	}
	
	void inicializarComponentes () {
		//Anular el gestor de organización (Layout)
		this.setLayout(null);
		
		JButton bt = new JButton("Pulsa aqui");  // Creaccion dle control
		bt.setBounds(50, 50, 100, 30);           //  propiedades del control			
		// Le damos "accion" al botón , implementando la interfaz ActionListener
		
		//bt.addActionListener(e->JOptionPane.showMessageDialog(MiVentana.this, "OLEEEEEE !!!!!!!!  "));
		
		
		JButton btsalir = new JButton("Salir");  // Creaccion dle control
		btsalir.setBounds(200, 200, 100, 30);           //  propiedades del control		
		// Le damos "accion" al botón , implementando la interfaz ActionListener
		btsalir.addActionListener(e-> MiVentana.this.dispose());
		
		
		JLabel lb = new JLabel(" blanco ");
		lb.setBounds(200, 250, 200, 30);
		
		bt.addActionListener(e-> lb.setText("Bienvenido a Swing"));   // Al pulsar en el boton, pone el texto a la etiqueta 
		
		
		
		this.add(bt);  //añadir el control (en este caso un boton) a la ventana
		this.add(btsalir);  //añadir el control (en este caso un boton) a la ventana
		this.add(lb);
		

	}

}

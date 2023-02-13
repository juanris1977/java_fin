package Presentacion;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import model.Libro;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLibros extends JFrame {

	private JPanel contentPane;
	private List<Libro> libros;

	
	public VentanaLibros(List<Libro> libros) {
		
		this.libros=libros;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea talibros = new JTextArea();
		talibros.setBounds(84, 33, 243, 112);
		contentPane.add(talibros);
		
		JButton btsalir = new JButton("Salir");
		btsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLibros.this.dispose();
			}
		});
		btsalir.setBounds(165, 186, 89, 23);
		contentPane.add(btsalir);
		
		
		addWindowListener(new WindowAdapter() {			
			@Override
			public void windowOpened(WindowEvent e) {
				//recogemos la lista de libros y la volcamos en el TextArea
				libros.forEach(l->talibros.setText(talibros.getText()+l.getTitulo()+"<br>"));    //  no entiendo esta linea !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			}
		});

		this.setVisible(true);
	}
}

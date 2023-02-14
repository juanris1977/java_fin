package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import model.Tema;

public class VentanaTemasTextArea extends JFrame {

	private JPanel contentPane;
	private List<Tema> temas;

	
	public VentanaTemasTextArea(List<Tema> temas) {
		
		this.temas=temas;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea talibros = new JTextArea();
		talibros.setBounds(84, 33, 243, 400); //
		
		contentPane.add(talibros);
		
		JButton btsalir = new JButton("Salir");
		btsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaTemasTextArea.this.dispose();
			}
		});
		btsalir.setBounds(165, 500, 89, 23);
		contentPane.add(btsalir);
		
		
		addWindowListener(new WindowAdapter() {			
			@Override
			public void windowOpened(WindowEvent e) {
				//recogemos la lista de libros y la volcamos en el TextArea
				talibros.setLineWrap(true);   // para ajuste de linea automatico
				temas.forEach(l->talibros.setText(talibros.getText()+ l.getTema()+"\n"));    //  no entiendo esta linea !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			}
		});

		this.setVisible(true);
	}
}

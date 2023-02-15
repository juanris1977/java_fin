package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.LibreriaServiceFactory;
import service.LibrosService;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class VentanaMenu extends JFrame {

	private JPanel contentPane;

	
	public VentanaMenu() {
		LibrosService libros = LibreriaServiceFactory.getLibrosService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConsultaVentas = new JButton("Consulta de ventas");
		btnConsultaVentas.setBounds(29, 42, 152, 23);
		contentPane.add(btnConsultaVentas);
		
		JButton btnLibros = new JButton("Consulta de libros");
		
		
		// Como hacer que escuche que hemos pulsado intro
		btnLibros.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					btnLibros.doClick();
				}
			}
		});
		
		
		btnLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaTemasCombo(libros.listaTemas());
			}
		});
		
		
		
		// Como hacer que escuche que hemos pulsado intro
		btnConsultaVentas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					btnConsultaVentas.doClick();
				}
			}
		});
		
		
		btnConsultaVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaVentas();
			}
		});


		btnLibros.setBounds(29, 86, 152, 23);
		contentPane.add(btnLibros);
		this.setVisible(true);
	}
}

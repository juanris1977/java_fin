package Presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import datamodel.AdaptadorComboTemas;
import datamodel.AdaptadorTablaLibros;
import model.Libro;
import model.Tema;
import service.LibreriaServiceFactory;
import service.LibrosService;
import javax.swing.JTable;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;



public class VentanaTemasCombo extends JFrame {

	private JPanel contentPane;
	private List<Tema> temas;
	private JTable tablelibros;
	private JScrollPane scrollPane_1 ;

	
	public VentanaTemasCombo(List<Tema> temas) {
		this.temas=temas;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
	
		scrollPane.setBounds(50, 50, 224, 30);
		contentPane.add(scrollPane);
		
		JComboBox<Tema> comboTemas = new JComboBox<Tema>();
		LibrosService service = LibreriaServiceFactory.getLibrosService();
		scrollPane.setViewportView(comboTemas);
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(50, 107, 677, 180);
		contentPane.add(scrollPane_1);		
		tablelibros = new JTable();
		scrollPane_1.setViewportView(tablelibros);
		
		
		VentanaTemasCombo.this.setVisible(true);
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// crear el adaptador con el modelos de datos y asignar al JList 
			
				regenerarLista(comboTemas);
				
				
			}
		});
		
		comboTemas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Tema t =  (Tema) comboTemas.getSelectedItem();  // cogemos el tema seleccionado
							
				var adapter1 = new AdaptadorTablaLibros( t.getTema());
				tablelibros.setModel(adapter1); 
				scrollPane_1.setVisible(true);   // ahora que ya está relleno lo mostramos
			
			}
		});
		
		
	}
	
	public void regenerarLista (JComboBox <Tema> lista ) { 
		var adapter = new AdaptadorComboTemas();
		lista.setModel(adapter);  // El adaptador es un listmodel porque heredamos defaultListModel que implementa Listmodel
		lista.addItem(new Tema(0, "Seleccione tema"));   // Sirve para "ponerle" titulo al combo
		scrollPane_1.setVisible(false);   // tenemos que dejarlo en false hasta que lo rellenemos

	}
}

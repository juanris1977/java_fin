package Presentacion;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import datamodel.AdaptadorComboTemas;
import datamodel.AdaptadorListaTemas;
import model.Tema;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class VentanaTemasCombo extends JFrame {

	private JPanel contentPane;
	private List<Tema> temas;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VentanaTemasCombo(List<Tema> temas) {
		this.temas=temas;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("seleccione tema");
		scrollPane.setName("");
		scrollPane.setBounds(50, 50, 224, 30);
		contentPane.add(scrollPane);
		
		JComboBox<Tema> comboTemas = new JComboBox<>();
		
		/*listTemas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// Obtenemos el elemento seleccionado y mostramos sus datos
			/*	Ciudad c = listCiudades.getSelectedValue();
				JOptionPane.showMessageDialog(VentanaCiudades.this, c.getNombre()+":"+c.getPoblacion());
		    */
				
		/*		//Al seleccionar un elemento, preguntar si queremos eliminar esa ciudad, y si dice que sí, se eliminará
				if (JOptionPane.showConfirmDialog(VentanaCiudades.this, "¿Desea eliminar la ciudad?")==JOptionPane.YES_OPTION) {
					Ciudad c = listCiudades.getSelectedValue();
					CiudadesService service = new CiudadesService();
					service.eliminarCiudad(c.getNombre());
					//reasignar adaptador a la lista
					regenerarLista(listCiudades);

				}
				
				
			}
		});*/
		scrollPane.setViewportView(comboTemas);
		
		JLabel lblNewLabel = new JLabel("Seleccione tema");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(52, 10, 116, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaTemasCombo.this.dispose();
			}
		});
		btnNewButton.setBounds(128, 130, 85, 21);
		contentPane.add(btnNewButton);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// crear el adaptador con el modelos de datos y asignar al JList 
				regenerarLista(comboTemas);
				
				
			}
		});
		this.setVisible(true);
		
	}
	
	public void regenerarLista (JComboBox <Tema> lista ) { 
		var adapter = new AdaptadorComboTemas();
		lista.setModel(adapter);  // El adaptador es un listmodel porque heredamos defaultListModel que implementa Listmodel
	}
}

package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import datamodel.AdaptadorTablaVentas;

public class VentanaVentas extends JFrame {

	private JPanel contentPane;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFin;
	private JTable table;

	public VentanaVentas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbFechaInicio = new JLabel("Fecha Inicio");
		lbFechaInicio.setBounds(10, 31, 86, 14);
		contentPane.add(lbFechaInicio);
		
		JLabel lbFechaFin = new JLabel("Fecha Fin");
		lbFechaFin.setBounds(10, 74, 58, 14);
		contentPane.add(lbFechaFin);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setBounds(81, 28, 96, 20);
		contentPane.add(txtFechaInicio);
		txtFechaInicio.setColumns(10);
		
		txtFechaFin = new JTextField();
		txtFechaFin.setColumns(10);
		txtFechaFin.setBounds(81, 71, 96, 20);
		contentPane.add(txtFechaFin);
		
		JButton btnVentas = new JButton("Ver ventas");
		
		btnVentas.setBounds(223, 70, 120, 23);
		contentPane.add(btnVentas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVisible(false);  
		scrollPane.setBounds(10, 116, 416, 136);
		contentPane.add(scrollPane);
		table = new JTable();
		btnVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var adapter = new AdaptadorTablaVentas(txtFechaInicio.getText(),txtFechaFin.getText());
				table.setModel(adapter);
				scrollPane.setVisible(true);  
			}
		});
		
	
		scrollPane.setViewportView(table);
	}
}

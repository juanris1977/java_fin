package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.ServiceTiendaCliente;
import service.ServiceTiendaClienteFactoria;

public class VentanaPedido extends JFrame {

	private JPanel contentPane;
	private JTextField textProducto;
	private JTextField textUnidades;
	private JTextField textTienda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPedido frame = new VentanaPedido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPedido() {
		ServiceTiendaCliente service = ServiceTiendaClienteFactoria.getPedidosService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Producto");
		lblNewLabel.setBounds(24, 29, 58, 14);
		
		JLabel lblNewLabel_1 = new JLabel("Unidades");
		lblNewLabel_1.setBounds(24, 67, 58, 14);
		
		JLabel lblNewLabel_2 = new JLabel("Tienda");
		lblNewLabel_2.setBounds(24, 105, 58, 14);
		
		textProducto = new JTextField();
		textProducto.setBounds(109, 26, 146, 20);
		textProducto.setColumns(10);
		
		textUnidades = new JTextField();
		textUnidades.setBounds(109, 64, 51, 20);
		textUnidades.setColumns(10);
		
		textTienda = new JTextField();
		textTienda.setBounds(109, 102, 146, 20);
		textTienda.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service.enviarPedido(textProducto.getText(), Integer.parseInt(textUnidades.getText()), textTienda.getText() );				
			}
		});
		btnEnviar.setBounds(109, 151, 96, 23);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(btnEnviar);
		contentPane.add(textProducto);
		contentPane.add(textTienda);
		contentPane.add(textUnidades);
	}
}

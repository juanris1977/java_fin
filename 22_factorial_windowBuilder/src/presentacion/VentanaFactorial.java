package presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaFactorial extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFactorial frame = new VentanaFactorial();
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
	public VentanaFactorial() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int op = JOptionPane.showConfirmDialog(VentanaFactorial.this, "¿Desea salir?");
				if (op==JOptionPane.YES_OPTION) {
					VentanaFactorial.this.dispose();
				}				
			}
			@Override
			public void windowActivated(WindowEvent e)  {
				Color color = new Color ((int)(Math.random()*256) , (int)(Math.random()*256) , (int)(Math.random()*256));
				VentanaFactorial.this.getContentPane().setBackground(color);  // cambia el color de fondo a la ventana				
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 535, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Factorial");
		lblNewLabel.setBounds(68, 41, 93, 36);
		contentPane.add(lblNewLabel);
		
		tf = new JTextField();
		tf.setBounds(159, 49, 86, 20);
		contentPane.add(tf);
		tf.setColumns(10);
		JLabel lbres = new JLabel("");
		
		btnNewButton = new JButton("factorial");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbres.setText("factorial: "+factorial(Integer.parseInt(tf.getName())));
			}
		});
		btnNewButton.setBounds(68, 112, 89, 23);
		contentPane.add(btnNewButton);
		
		
		lbres.setBounds(68, 172, 46, 14);
		contentPane.add(lbres);
	}
	 int factorial(int numero) {			
				 return IntStream.rangeClosed(1, numero)
				         .reduce(1, (a,b) -> a*b);
	 }
}

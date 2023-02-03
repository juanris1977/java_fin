package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EliminarContacto {

	public static void main(String[] args) {
		//Pide por teclado la introduccion de un nombre y elimina el contacto con dicho nombre
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce nombre");
		String nombre = sc.nextLine();
		
		// paso 1: Establecer conexión a la bbdd 
				String cadenaCon = "jdbc:mysql://localhost:3306/agenda";
				String user="root";
				String pwd= "root";
			
				
				try (Connection con = DriverManager.getConnection(cadenaCon, user, pwd);) {
				
					// envio instruccion SQL
			/*		String sql = "delete from contactos where nombre='"+nombre+"'" ;  // para concatenar ambas cadenas y que se conviertan en una
						  
										
					System.out.println(sql);
					Statement st = con.createStatement();
					st.execute(sql);*/
					
				    //  Usamos PrepareStatment , para consultas parametrizadas
					String sql = "delete from contactos where nombre=?";   //esperará que le demos el nombre
					PreparedStatement ps = con.prepareStatement(sql); 
					// sustituir parámetros por sus valores 
					ps.setString(1, nombre);   //  al parámetro 1 asignale el valor de la variable nombre 
					//ejecucion
					ps.execute();
					
				}// se cierra solo al salir del try con recursos
				catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}

package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InserccionContacto {

	public static void main(String[] args) {
		
		// paso 1: Establecer conexión a la bbdd 
		String cadenaCon = "jdbc:mysql://localhost:3306/agenda";
		String user="root";
		String pwd= "root";
	/*	Connection con = DriverManager.getConnection(cadenaCon, user, pwd);
		
		// envio instruccion SQL
		String sql = "insert into contactos (nombre, email, edad) values ('Irene', 'irene@gmail.com', 32)";
		Statement st = con.creatreStatement();
		st.execute(sql);
		
		// cerrar conexion
		con.close();*/
		
		try (Connection con = DriverManager.getConnection(cadenaCon, user, pwd);) {
		
			// envio instruccion SQL
			String sql = "insert into contactos (nombre, email, edad) values ('Irene', 'irene@gmail.com', 32)";
			Statement st = con.createStatement();
			st.execute(sql);	
		}// se cierra solo al salir del try con recursos
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}

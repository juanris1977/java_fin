package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestLectura {

	public static void main(String[] args) {

		String cadenaCon="jdbc:mysql://localhost:3306/agenda";
		String user="root";
		String pwd="root";
		
		try (Connection con = DriverManager.getConnection(cadenaCon,user,pwd);){
			String sql = " Select * from contactos" ;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);  // Sólo va hacia adelante y no se puede volver y sólo es de Lectura
			while (rs.next()) {    // el objeto rs va apuntando a las filas ..., es true mientras haya una fila a la que apuntar
				System.out.print(rs.getString("nombre")+" : ");  // te da el valor para esa fila de la columna "nombre"
				System.out.print(rs.getString("email")+" --> ");  // te da el valor para esa fila de la columna "email"
				System.out.println(rs.getInt("edad"));    //  te da el valor de esa fila para la columna edad 
				//System.out.println(rs.getString(4));    //  te da el valor de esa fila para la cuarta columna
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}

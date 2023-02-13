package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import service.locator.ConectionLocator;


public class ServiceLibrosImpl1 implements LibrosService {
	
	@Override
	public boolean comprobarLogin(String usuario, String pass) {
		
		try(Connection con = ConectionLocator.getConnection();){
			String sql="select usuario , password from clientes where usuario = ? and password = ?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			
			return rs.next();  // Si la consulta devuelve datos es que el usuario y contraseña están en la tabla y el login es correcto
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}

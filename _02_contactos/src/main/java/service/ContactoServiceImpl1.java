package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Contacto;
import service.locator.ConnectionLocator;

public class ContactoServiceImpl1 implements ContactoService {
	

	
	@Override
	public void agregarContacto(Contacto contacto) {
	
		try(Connection con = ConnectionLocator.getConnection();){
			String sql="insert into contactos(nombre,email,edad) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, contacto.getNombre());
			ps.setString(2, contacto.getEmail());
			ps.setInt(3, contacto.getEdad());
			ps.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void eliminarContacto(String nombre) {
		try(Connection con = ConnectionLocator.getConnection();){
			String sql="delete from contactos where nombre=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void modificarContacto (String nombre, String email) {
		try(Connection con = ConnectionLocator.getConnection();){
			String sql="update contactos set email=? where nombre=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, nombre);
			ps.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public List<Contacto> mostrarAgenda() {
		List<Contacto> listacontactos = new ArrayList<>();
		try(Connection con = ConnectionLocator.getConnection();){
			String sql="select * from contactos order by edad";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Contacto contacto=new Contacto(rs.getInt(1), rs.getString("nombre"),rs.getString("email"),rs.getInt("edad"));
				listacontactos.add(contacto);				
			}
			return listacontactos;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<String> listaNombres () {
		List<String> listacontactos = new ArrayList<>();
		try(Connection con = ConnectionLocator.getConnection();){
			String sql="select nombre , email from contactos";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				listacontactos.add(rs.getString("nombre")+"-->"+rs.getString("email"));				
			}
			return listacontactos;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
}
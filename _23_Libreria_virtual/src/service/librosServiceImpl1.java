package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Libro;
import model.Tema;
import service.locator.ConectionLocator;



public class librosServiceImpl1 implements LibrosService {

	@Override
	public List<Libro> listaLibros() {
		List<Libro> libros = new ArrayList<>();
		try(Connection con = ConectionLocator.getConnection();){
			String sql="select * from libros";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {			
				Libro libro=new Libro(rs.getInt("isbn"), 
						              rs.getString("titulo"),
						              rs.getString("autor"),
						              rs.getDouble("precio"), 
						              rs.getInt("paginas"),
						              rs.getInt("idtema")									  
									 ); 
				libros.add(libro);				
			}	
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		return libros;
		
		
	}

	@Override
	public List<Libro> librosTema(String tema) {
		List<Libro> libros = new ArrayList<>();
		try(Connection con = ConectionLocator.getConnection();){
			String sql="select libros.isbn , libros.titulo, libros.autor, libros.precio, libros.paginas, "
					+ "libros.idtema from libros , temas  where tema = ? and libros.idtema = temas.idtema";			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tema);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {			
				Libro libro=new Libro(rs.getInt("isbn"), 
						              rs.getString("titulo"),
						              rs.getString("autor"),
						              rs.getDouble("precio"), 
						              rs.getInt("paginas"),
						              rs.getInt("idtema")									  
									 ); 
				libros.add(libro);				
			}	
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		return libros;
		
		
	}

	@Override
	public List<Tema> listaTemas() {
		List<Tema> temas = new ArrayList<>();
		try(Connection con = ConectionLocator.getConnection();){
			String sql="select idtema, tema from temas";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {		
				
				Tema tema = new Tema (rs.getInt("idtema"),
									  rs.getString("tema"));	
				temas.add(tema);
			}	
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		return temas;
				
	}
}

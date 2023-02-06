package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Curso;
import service.locator.ConnectionLocator;

public class CursoServiceImpl implements CursosService{

	@Override
	public List<Curso> cursosPorFechaInicioMax(LocalDate fechalimite) {
		List<Curso> cursos = new ArrayList<>();
		try(Connection con = ConnectionLocator.getConnection();){
			String sql="select * from cursos where fechainicio<?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			//fechalimite es un LocalDate de java , que debemos convertir a un date de sql			
			ps.setDate(1, Date.valueOf(fechalimite));
						
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {			
				Curso curso=new Curso(rs.getInt(1), 
						              rs.getString(2),
						              rs.getDouble(3),
						              rs.getDouble(4), 
									  rs.getDate(5).toLocalDate()       // hay que transformar el sql date a java Localdate
									 ); 
				cursos.add(curso);				
			}	
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		return null;
	}
}

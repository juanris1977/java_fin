package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Alumno;
import model.Curso;
import service.locator.ConnectionLocator;

public class CursoServiceImpl implements CursoService{

	@Override
	public List<Curso> cursosPorFechaInicioMax(LocalDate fechalimite) {
		List<Curso> cursos = new ArrayList<>();
		try(Connection con = ConnectionLocator.getConnection();){
			String sql="select * from cursos where fechainicio<=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			//fechalimite es un LocalDate de java , que debemos convertir a un date de sql			
			ps.setDate(1, Date.valueOf(fechalimite));
						
			ResultSet rs = ps.executeQuery();
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
		return cursos;
	}
	
	@Override
	public List<Curso> listaCursos() {
		List<Curso> cursos = new ArrayList<>();
		try(Connection con = ConnectionLocator.getConnection();){
			String sql="select * from cursos";
			PreparedStatement ps = con.prepareStatement(sql);						
			ResultSet rs = ps.executeQuery();
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
		return cursos;
	}
	
	@Override
	public List<Alumno> listaAlumnosCurso(int idcurso) {
		List<Alumno> alumnos = new ArrayList<>();
		try(Connection con = ConnectionLocator.getConnection();){
			String sql="select * from alumnos where idcurso=?";
			PreparedStatement ps = con.prepareStatement(sql);	
			ps.setInt(1, idcurso);			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {		
				String dni = rs.getString("idalumno");
				String nombre =  rs.getString("nombre");
				String email =  rs.getString("email");
				Double nota = rs.getDouble("nota");
				// comprobamos si era nulo
			//	nota = rs.wasNull() ? null : nota ;   //  Si lo que habia en la columna era nulo, lo mantiene, sino, devuelve el numero
				int curso =  rs.getInt("idcurso");    
				
				Alumno alumno=new Alumno(dni, nombre, email, nota, curso);  // quiero que nota pueda guardarse como nulo
				alumnos.add(alumno);				
			}	
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		return alumnos;		
	}
	
	@Override
	public void AltaAlumnoCurso (String dni, String  nombre, String email, double nota , int idcurso) {
		try(Connection con = ConnectionLocator.getConnection();){
			String sql="insert into alumnos (idalumno, nombre, email,nota,  idcurso) values (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);	
			ps.setString(1, dni);	
			ps.setString(2, nombre);		
			ps.setString(3, email);
			ps.setDouble(4, nota);
			ps.setInt(5, idcurso);
			ps.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			
		}
	}
	 
	public 	String nombreCurso(int idcurso) {
		String res = null;
		try(Connection con = ConnectionLocator.getConnection();){
			String sql="select nombrecurso from cursos where idcurso=?";
			PreparedStatement ps = con.prepareStatement(sql);	
			ps.setInt(1, idcurso);			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {			
				res = rs.getString(1);
							
			}	
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		return res;		
		
	}



}

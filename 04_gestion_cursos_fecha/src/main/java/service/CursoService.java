package service;

import java.time.LocalDate;
import java.util.List;

import model.Alumno;
import model.Curso;

public interface CursoService {

	List<Curso> cursosPorFechaInicioMax(LocalDate fechalimite);
	List<Curso> listaCursos();
	List<Alumno> listaAlumnosCurso(int idcurso);
	void AltaAlumnoCurso (String dni, String  nombre, String email,double nota,  int idcurso);
	String nombreCurso(int idcurso);

	
}

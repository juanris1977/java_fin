package service;

import java.time.LocalDate;
import java.util.List;

import model.Alumnos;
import model.Curso;

public interface CursoService {

	List<Curso> cursosPorFechaInicioMax(LocalDate fechalimite);
	List<Curso> listaCursos();
	List<Alumnos> listaAlumnosCurso(int idcurso);
	void AltaAlumnoCurso (String dni, String  nombre, String email,  int idcurso);
	void AltaAlumnoCursoNota (String dni, String  nombre, String email,Double nota,   int idcurso);
	String nombreCurso(int idcurso);

	
}

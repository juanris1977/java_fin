package view;

import java.time.LocalDate;

import model.Alumno;
import service.CursoServiceFactory;
import service.CursoService;

public class Test {

	public static void main(String[] args) {
		CursoService service = CursoServiceFactory.getCursoService();
		
		service.listaAlumnosCurso(1).stream().forEach(c->System.out.println(c));

	}

}

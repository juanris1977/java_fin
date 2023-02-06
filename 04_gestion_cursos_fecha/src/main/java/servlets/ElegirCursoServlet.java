package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Curso;
import service.CursoService;
import service.CursoServiceFactory;


@WebServlet("/ElegirCursoServlet")
public class ElegirCursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursoService service = CursoServiceFactory.getCursoService();
		List<Curso> cursos = service.listaCursos();
		request.setAttribute("cursos", cursos);
		request.getRequestDispatcher("elegircurso.jsp").forward(request, response);

		
	}

}

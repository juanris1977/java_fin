package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CursoService;
import service.CursoServiceFactory;


@WebServlet("/MostrarCursosFechaServlet")
public class MostrarCursosFechaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursoService service = CursoServiceFactory.getCursoService();
				
	LocalDate fecha= LocalDate.parse(request.getParameter("fecha"));   // fecha nos viene en un string, para pasarlo a LocalDate (yyyy-MM-dd) hacemos un parse simple
	//	LocalDate fecha= LocalDate.parse("2024-01-01");
		request.setAttribute("cursos", service.cursosPorFechaInicioMax(fecha));
		
		request.getRequestDispatcher("MostrarCursos.jsp").forward(request, response);
	}
}

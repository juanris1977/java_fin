package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CursoService;
import service.CursoServiceFactory;


@WebServlet("/AltaAlumnoCursoServlet")
public class AltaAlumnoCursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursoService service = CursoServiceFactory.getCursoService();
		
		int idcurso = Integer.parseInt(request.getParameter("curso"));
		int nota = Integer.parseInt(request.getParameter("nota"));
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		
		service.AltaAlumnoCurso(dni, nombre, email, idcurso, nota);  
		request.getRequestDispatcher("inicio.html").forward(request, response);


	}

}

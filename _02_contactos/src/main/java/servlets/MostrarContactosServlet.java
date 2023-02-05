package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;
import service.ContactoService;
import service.ContactoServiceFactory;


@WebServlet("/MostrarContactosServlet")
public class MostrarContactosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactoService service=ContactoServiceFactory.getContactosService();
		
		List<Contacto> nombres = service.mostrarAgenda();
		request.setAttribute("nombres", nombres);
		request.getRequestDispatcher("MostrarContactos.jsp").forward(request, response);
	}

}

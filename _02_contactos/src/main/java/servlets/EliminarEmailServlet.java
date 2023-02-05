package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ContactoService;
import service.ContactoServiceFactory;


@WebServlet("/EliminarEmailServlet")
public class EliminarEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactoService service=ContactoServiceFactory.getContactosService();
		
		String nombre = request.getParameter("modificar");
		String email = request.getParameter("email");
		service.modificarContacto(nombre, email);
		request.getRequestDispatcher("inicio.html").forward(request, response);
	}

}

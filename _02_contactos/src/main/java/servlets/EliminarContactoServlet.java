package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;
import service.ContactoService;
import service.ContactoServiceFactory;


@WebServlet("/EliminarContactoServlet")
public class EliminarContactoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactoService service=ContactoServiceFactory.getContactosService();
		
		String elimina = request.getParameter("eliminar");
		service.eliminarContacto(elimina);
		request.getRequestDispatcher("inicio.html").forward(request, response);
	}

}

package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;
import service.ContactoService;
import service.ContactoServiceFactory;

@WebServlet("/AltaContactoServlet")
public class AltaContactoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactoService service=ContactoServiceFactory.getContactosService();
		//recogemos parámetros
		String nom=request.getParameter("nombre");
		String email=request.getParameter("email");
		int edad=Integer.parseInt(request.getParameter("edad"));
		//creamos el objeto contacto con los datos recibidos y llamamos al método de alta
		Contacto contacto=new Contacto(0, nom, email, edad);
		service.agregarContacto(contacto);
		//pasamos el control a la página de nuevo
		request.getRequestDispatcher("contactos.html").forward(request, response);
		
	}


}

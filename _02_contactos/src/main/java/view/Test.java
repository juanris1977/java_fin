package view;

import model.Contacto;
import service.ContactoService;
import service.ContactoServiceFactory;

public class Test {

	public static void main(String[] args) {
		ContactoService service = ContactoServiceFactory.getContactosService();
		
	/*	service.agregarContacto(new Contacto(0, "pepe","pepe@gmail.coml",32));
		service.agregarContacto(new Contacto(0, "juan","juan@gmail.coml",32));
		service.agregarContacto(new Contacto(0, "maria","maria@gmail.coml",32));
		service.eliminarContacto("pepe");
		service.modificarContacto("maria", "soymaria@gmail.com");*/
		service.mostrarAgenda().stream()
						       .forEach(c -> System.out.println(c));


	}


}
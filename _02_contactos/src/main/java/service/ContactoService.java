package service;

import java.util.List;

import model.Contacto;

public interface ContactoService {

		

		void agregarContacto(Contacto contacto);
		public void eliminarContacto(String nombre);
		public void modificarContacto (String nombre, String email);
		public List<Contacto> mostrarAgenda();
		public List<String> listaNombres ();

}
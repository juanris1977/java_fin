package service;

import java.util.List;

import model.Libro;
import model.Tema;
import model.Venta;

public interface LibrosService {
	List<Libro> listaLibros ();
	List<Tema> listaTemas();
	List<Libro> librosTema (String tema);
	List<Venta> ventasFecha (String FechaInicio, String FechaFin);

}

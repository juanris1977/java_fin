package service;

import java.util.ArrayList;
import java.util.List;

import model.Ciudad;

public class CiudadesService {
	static List<Ciudad> ciudades=new ArrayList<>(List.of(new Ciudad("Valladolid",230000, 21.2),
														 new Ciudad("Santander",100000, 23.2),
														 new Ciudad("Valencia",1230000, 14),
														 new Ciudad("Madrid",3230000, 17),
														 new Ciudad("Burgos",90000, 18.2)));
	
	public List<Ciudad> todas() {
		return ciudades;
	}
	
	public void eliminarCiudad (String nombre) {
		ciudades.removeIf(c-> c.getNombre().equalsIgnoreCase(nombre));
	}

}

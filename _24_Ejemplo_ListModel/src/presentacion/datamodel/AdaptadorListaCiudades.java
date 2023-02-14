package presentacion.datamodel;

import java.util.List;

import javax.swing.DefaultListModel;

import model.Ciudad;
import service.CiudadesService;

public class AdaptadorListaCiudades extends DefaultListModel<Ciudad> {
	List<Ciudad> ciudades;
	public AdaptadorListaCiudades () {
		// se conecta a la capa de negocio para obtener los datods originales uqe queremos mostrar en el jlist
		CiudadesService service = new CiudadesService ();
		ciudades = service.todas();
	}
	
	//sobreescribimos los metodos que van a ser llamados por el Jlist
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return ciudades.size();
	}
	@Override
	public Ciudad getElementAt(int index) {
		// TODO Auto-generated method stub
		return ciudades.get(index);
	}
	
	
	
	

}

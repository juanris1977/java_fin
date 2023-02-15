package datamodel;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Tema;
import service.LibreriaServiceFactory;
import service.LibrosService;



public class AdaptadorComboTemas extends DefaultComboBoxModel<Tema> {
	List<Tema> temas;
	public AdaptadorComboTemas () {
		// se conecta a la capa de negocio para obtener los datods originales uqe queremos mostrar en el jlist
		LibrosService service = LibreriaServiceFactory.getLibrosService();
		temas = service.listaTemas();
	}
	
	//sobreescribimos los metodos que van a ser llamados por el Jlist
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return temas.size();
	}
	@Override
	public Tema getElementAt(int index) {
		// TODO Auto-generated method stub
		return temas.get(index);
	}
	
	
	
	

}

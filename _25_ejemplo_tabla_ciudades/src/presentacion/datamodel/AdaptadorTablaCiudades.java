package presentacion.datamodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Ciudad;
import service.CiudadesService;

public class AdaptadorTablaCiudades extends AbstractTableModel{

	List <Ciudad> ciudades;
	
	public AdaptadorTablaCiudades() {
		CiudadesService service = new CiudadesService();
		ciudades= service.todas();
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return ciudades.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		//return 3;
		return Ciudad.class.getDeclaredFields().length;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
	/*	switch (column) {
		case 0: 
			return "Nombre Ciudad";
		case 1: 
			return "Población";
		case 2:
			return "Temperatura media";		
		}
		return"";*/
		
		//desde java 17 , switch en expresiones
		return switch (column) {
			case 0 -> "Nombre ciudad";
			case 1 -> "Población";
			case 2 -> "Temperatura media";
			default -> "";
		};
	}

	//Debe proporcionar el contenido de cada celda 
	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return switch (column) {
		case 0 ->ciudades.get(row).getNombre();
		case 1 ->ciudades.get(row).getPoblacion();
		case 2 ->ciudades.get(row).getTemperatura();
		default -> "";
		};
	}
	
	//proporciona el tipo de dato de cada columna
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
	/*	return switch (columnIndex) {
		case 0 -> String.class;
		case 1 -> Integer.class;
		case 2 -> Double.class;
		default -> null;
		};*/
		return Ciudad.class.getDeclaredFields()[columnIndex].getClass();

	}
}

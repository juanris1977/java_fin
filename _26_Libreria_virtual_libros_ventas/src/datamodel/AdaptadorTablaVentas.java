package datamodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Libro;
import model.Venta;
import service.LibreriaServiceFactory;
import service.LibrosService;

public class AdaptadorTablaVentas extends AbstractTableModel{
	List <Venta> ventas;  // es lo que vamos a querer mostrar en esta tabla
	
	public AdaptadorTablaVentas (String  fechainicio, String fechafin) {
		
		LibrosService service  = LibreriaServiceFactory.getLibrosService();
		ventas = service.ventasFecha(fechainicio, fechafin);
	
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return ventas.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
		
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
			case 0 -> "Título";
			case 1 -> "Autor";
			case 2 -> "Tema";
			case 3 -> "Fecha Compra";		
			default -> "";
		};
	}

	//Debe proporcionar el contenido de cada celda 
	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return switch (column) {
				
			case 0 -> ventas.get(row).getTitulo();
			case 1 -> ventas.get(row).getAutor();
			case 2 -> ventas.get(row).getTema();
			case 3 -> ventas.get(row).getFecha();
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
		return Venta.class.getDeclaredFields()[columnIndex].getClass();

	}
}

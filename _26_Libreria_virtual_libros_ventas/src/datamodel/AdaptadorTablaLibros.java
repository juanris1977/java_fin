package datamodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;


import model.Libro;
import service.LibreriaServiceFactory;
import service.LibrosService;

public class AdaptadorTablaLibros extends AbstractTableModel{
	
	List <Libro> libros;  // es lo que vamos a querer mostrar en esta tabla
	
	public AdaptadorTablaLibros (String  tema) {
		LibrosService service  = LibreriaServiceFactory.getLibrosService();
		libros = service.librosTema(tema);
	
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return libros.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
		//return Libro.class.getDeclaredFields().length;
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
			case 0 -> "Isbn";
			case 1 -> "Titulo";
			case 2 -> "Autor";
			case 3 -> "Precio";
			case 4 -> "Páginas";
		//	case 5 -> "IdTema";
			default -> "";
		};
	}

	//Debe proporcionar el contenido de cada celda 
	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return switch (column) {
				
			case 0 -> libros.get(row).getIsbn();
			case 1 -> libros.get(row).getTitulo();
			case 2 -> libros.get(row).getAutor();
			case 3 -> libros.get(row).getPrecio();
			case 4 -> libros.get(row).getPaginas();
		//	case 5 -> libros.get(row).getIdTema();
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
		return Libro.class.getDeclaredFields()[columnIndex].getClass();

	}
}

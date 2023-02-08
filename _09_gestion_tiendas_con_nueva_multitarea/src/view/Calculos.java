package view;

import service.TiendaService;
import service.TiendaServiceFactory;

public class Calculos {

	public static void main(String[] args) {
		// de manera concurrente nos mostrará el total de unidades pedidas 
		// y el nombre del ultimo producto pedido segun la fecha de pedido
		TiendaService service = TiendaServiceFactory.getTiendaService();
		
		new Thread( 
				   () -> System.out.println(service.totalUnidadesPedidas())  // hacemos una implementacion del método run, al que le decimos que es lo que hay que ejecutar
				   ).start();
	
		new Thread( 
				   () -> System.out.println(service.ultimoProducto())		// hacemos una implementacion del método run, al que le decimos que es lo que hay que ejecutar
				   ).start();
	}
}


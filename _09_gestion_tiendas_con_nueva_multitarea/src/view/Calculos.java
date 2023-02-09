package view;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import service.TiendaService;
import service.TiendaServiceFactory;

public class Calculos {

	public static void main(String[] args) {
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		// de manera concurrente nos mostrará el total de unidades pedidas 
		// y el nombre del ultimo producto pedido segun la fecha de pedido
		TiendaService service = TiendaServiceFactory.getTiendaService();
		
		exec.submit( 
				   () -> System.out.println(service.totalUnidadesPedidas())  // hacemos una implementacion del método run, al que le decimos que es lo que hay que ejecutar
				   );
	
		exec.submit( 
				   () -> System.out.println(service.ultimoProducto())		// hacemos una implementacion del método run, al que le decimos que es lo que hay que ejecutar
				   );
		exec.shutdown();
	}
}


package principal;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import service.ServiceCovid;
import service.ServiceCovidFactory;
import tareas.CasosTotalesSupplier;

public class Lanzador {

	public static void main(String[] args) {
		
		ServiceCovid service = ServiceCovidFactory.getServiceCovid();   //  Le pedimos a la factoria una implementacion del interfaz
		

		ExecutorService exec = Executors.newCachedThreadPool();
		// CompletableFuture <Integer> future = CompletableFuture.supplyAsync(new CasosTotalesSupplier(), exec);   // no es necesario hacer una clase para ello
		
		CompletableFuture <Integer> future = CompletableFuture.supplyAsync( () -> service.casosTotales(), exec);   // Podemos aprovechar que el supplier es una interfaz funcional para implementarlo con una lambda

		future.whenCompleteAsync( (r,e) -> System.out.println("Los casos totales en europa son   ---------------------->>>>: "+r));
		
		
	    /*	service.paises()   //  Nos da una lista de string con los nombres de los paises
			  // .stream()   // Stream <String>     sobra, porque el foreach puede hacerse en una lista directamente
			   .forEach(p -> System.out.println("Incidencia acumulada de "+p+": " +  service.incidenciaAcumulada(p)));  */
		
		
		// Lanzamos el calculo de la incidencia de cada pais como tarea independiente	
		service.paises()
		       .forEach( p -> exec.submit( ()-> System.out.println("Incidencia acumulada de "+p+": " +  service.incidenciaAcumulada(p))));
		
		
		exec.shutdown();

		
	

	}

}

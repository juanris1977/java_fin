package principal;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tareas.SumaNumerosSupplier;

public class LanzadorCompletableFuture {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();

		// si quieres que te de un completablefuture has de usar un supplier en lugar de callabe		
		CompletableFuture <Integer> future = CompletableFuture.supplyAsync(new SumaNumerosSupplier(), exec);
		
		//definimos el código de respuesta que debe ser ejecutado cuando la tarea finalice 
		future.whenCompleteAsync( (r,e) -> System.out.println("La suma es: "+r));
		
		for(int i=1; i<100;i++) {
			System.out.println("haciendo algo");
			Thread.sleep(100);
		}
		exec.shutdown();
	}

}

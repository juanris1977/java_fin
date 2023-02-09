package principal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import tareas.SumaNumeros;

public class Lanzador {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// queremos lanzar la tarea que sume del 1 al 100, pero a la vez que haga otras cosas
		// y que cuando termine la tarea nos diga
		
		ExecutorService exec = Executors.newCachedThreadPool();
		Future<Integer> future = exec.submit(new SumaNumeros());  // Suma numeros es un callable
																	// Pone sumanumeros a ejecutarse de forma concurrnete
		
		for(int i=1; i<100;i++) {
			System.out.println("haciendo algo");
			Thread.sleep(100);
			//vamos preguntando si la tarea ha terminado o no
			// cuando finaliza, obtenemos el resultado y lo mostramos
			
			if (future.isDone()) {
				System.out.println("La suma vale:  ................................"
						+ "   "+future.get());
			}
			exec.shutdown();
		}
		

	}

}

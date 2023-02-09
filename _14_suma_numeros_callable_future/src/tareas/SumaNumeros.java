package tareas;

import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class SumaNumeros implements Callable<Integer> {
	
	//suma de los numeros del 1 al 100

	@Override
	public Integer call() throws Exception {
		int suma = 0;
		for (int i=0;i<10;i++) {
			suma+=i;
			Thread.sleep(100);
		}
		return suma;
		
		
	}

}

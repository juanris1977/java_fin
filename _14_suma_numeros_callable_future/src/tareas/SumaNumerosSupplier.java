package tareas;

import java.util.function.Supplier;

public class SumaNumerosSupplier implements Supplier<Integer> {
	
	//suma de los numeros del 1 al 100

	
	@Override
	public Integer get() {
		int suma = 0;
		for (int i=0;i<10;i++) {
			suma+=i;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return suma;
		
	}

}

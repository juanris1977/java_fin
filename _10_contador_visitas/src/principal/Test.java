package principal;

import model.Contador;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		// para probar el contador , creamos un objeto contador y 3 tareas concurrentes que llaman a incrementar		
		//  Despues mostramos el valor del contador
		
		Contador contador = new Contador();
		
		new Thread( () -> contador.incrementar() ).start();
		new Thread( () -> contador.incrementar() ).start();
		new Thread( () -> contador.incrementar() ).start();
		
		Thread.sleep(1000);
		
		System.out.println(contador.getValor());
		
	}
}

package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import model.Contador;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		// para probar el contador , creamos un objeto contador y 3 tareas concurrentes que llaman a incrementar		
		//  Despues mostramos el valor del contador
		
		Contador contador = new Contador();
		
		Lock  lk= new ReentrantLock();
		ExecutorService exec = Executors.newCachedThreadPool();
		
		Runnable r = () -> {
								lk.lock();
								contador.incrementar();
								lk.unlock();
							 };
		// lanzamos las tareas
		exec.submit(r);
		exec.submit(r);
		exec.submit(r);
		Thread.sleep(1000);

		System.out.println(contador.getValor());
	}
		
}


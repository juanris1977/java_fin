package view;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tareas.ProcesarPedido;

public class Lanzador {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();
		ProcesarPedido p1 = new ProcesarPedido("C:\\ficheroseclipse\\tienda1.csv");
		ProcesarPedido p2 = new ProcesarPedido("C:\\ficheroseclipse\\tienda2.csv");
		ProcesarPedido p3 = new ProcesarPedido("C:\\ficheroseclipse\\tienda3.csv");
		
		executor.submit(p1);
		executor.submit(p2);
		executor.submit(p3);
		
		System.out.println("Tareas en proceso");
		//el pool de executor service cuando termina 
		//de ejecutar las tareas sigue en proceso aunque las 
		//tareas hayan terminado al cabo de un rato cuando el jdk 
		//se da cuenta que es no lo usa nadie lo apaga pero eso se puede 
		//forzar para cerrar el proceso cuando acabe la tarea deseada y para eso ponemos 
		executor.shutdown();//en resumen para vaciar el pool

		
		
	}

}

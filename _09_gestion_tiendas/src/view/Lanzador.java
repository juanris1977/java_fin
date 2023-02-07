package view;

import tareas.ProcesarPedido;

public class Lanzador {

	public static void main(String[] args) {

		ProcesarPedido p1 = new ProcesarPedido("C:\\ficheroseclipse\\tienda1.csv");
		ProcesarPedido p2 = new ProcesarPedido("C:\\ficheroseclipse\\tienda2.csv");
		ProcesarPedido p3 = new ProcesarPedido("C:\\ficheroseclipse\\tienda3.csv");
		
		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(p3).start();

		
		
	}

}

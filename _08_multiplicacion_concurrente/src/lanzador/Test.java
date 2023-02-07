package lanzador;

import tareas.Multiplicar;

public class Test {

	public static void main(String[] args) {
		
		Multiplicar t4 = new Multiplicar(4);
		Multiplicar t3 = new Multiplicar(3);
		Multiplicar t2 = new Multiplicar(2);
		
		new Thread(t4).start();
		new Thread(t3).start();
		new Thread(t2).start();

	}

}

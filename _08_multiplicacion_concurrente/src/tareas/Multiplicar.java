package tareas;

public class Multiplicar implements  Runnable {
	
	int numero;
	
	
	public Multiplicar(int numero) {
		
		this.numero = numero;
	}




	@Override
	public void run() {
		for (int i=1;i<=10; i++) {
			System.out.println(numero+" x "+ i + " es "+ numero*i);
		
		}

	}
}

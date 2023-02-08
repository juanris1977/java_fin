package principal;

import java.util.ArrayList;
import java.util.List;

import tareas.Ascendente;
import tareas.Descendente;

public class Lanzador {

	public static void main(String[] args) throws InterruptedException {
		
		List<String> textos = new ArrayList<>();
		Ascendente t1=new Ascendente(textos);
		Descendente t2=new Descendente(textos);
		
		new Thread(t1).start();  //  se crea un nuevo thread dandole como parametro el runnable
		new Thread(t2).start();
		
		Thread.sleep(5000);
		
		System.out.println(
							textos.size()
						   );
		}
	}



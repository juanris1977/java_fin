package principal;

import model.DiaSemana;
import model.Tienda;

public class Test {

	public static void main(String[] args) {
		// crear una tienda con el dia de cierre jueves
		
		var tienda = new Tienda ("t1", "aaaa", DiaSemana.Martes);
		switch (tienda.getDiaCierre()) {
			case Lunes:
			case Domingo:	
		
		}
		

	}

}

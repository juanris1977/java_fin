package principal;

public class MiSingleton {
	private static MiSingleton instance;
	// unos cuantos métodos
	
	private MiSingleton()  {   // Constructor privado , eso ya evita que se puedan crear objetos de esta clase 
		
	}
	
	//todas las llamadas a getinstance devuelven el mismo y único onjeto
	public static MiSingleton getInstance() {
		
		if (instance==null) {
			instance = new MiSingleton();			
		}
		return instance;
		
	}

}

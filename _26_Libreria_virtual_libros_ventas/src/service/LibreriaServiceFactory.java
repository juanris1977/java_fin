package service;

public class LibreriaServiceFactory {
	public static ClientesService getClientesService () {
		return new ClientesServiceImpl1();
	}
	
	public static LibrosService getLibrosService () {
		return new librosServiceImpl1();
	}
}

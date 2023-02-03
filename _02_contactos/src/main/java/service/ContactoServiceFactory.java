package service;

public class ContactoServiceFactory {
	
	public static ContactoService getContactosService() {
		
	
		return new ContactoServiceImpl1();
	}
}

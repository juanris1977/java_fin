package service;

public class CursoServiceFactory {
	
	public static CursoServiceImpl getCursoService () {
		
		return new CursoServiceImpl();
	}
}

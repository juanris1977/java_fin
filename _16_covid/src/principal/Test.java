package principal;

import service.ServiceCovid;
import service.ServiceCovidFactory;

public class Test {

	public static void main(String[] args) {
		ServiceCovid service = ServiceCovidFactory.getServiceCovid();
		
		System.out.println("Totales normales: "+service.casosTotales());
		System.out.println(service.casosTotalesGroup());
		System.out.println(service.paises());
		System.out.println(service.incidenciaAcumulada("Spain"));
		System.out.println(service.casosTotalesPais("Spain"));

	}

}

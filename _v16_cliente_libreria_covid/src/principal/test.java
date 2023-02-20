package principal;

import service.ServiceCovid;
import service.ServiceCovidFactory;

public class test {

	public static void main(String[] args) {
		
		ServiceCovid service = ServiceCovidFactory.getServiceCovid();
		service.paises().forEach(c -> System.out.println(c));

	}

}

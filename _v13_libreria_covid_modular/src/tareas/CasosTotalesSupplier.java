package tareas;

import java.util.function.Supplier;

import service.ServiceCovid;
import service.ServiceCovidFactory;

public class CasosTotalesSupplier implements Supplier<Integer> {

	@Override
	public Integer get() {
		ServiceCovid service = ServiceCovidFactory.getServiceCovid();
		return service.casosTotales();
	}

}

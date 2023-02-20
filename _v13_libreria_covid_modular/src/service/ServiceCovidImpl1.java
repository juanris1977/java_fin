package service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import model.Item;
import service.locator.LocatorCovid;
import static utilities.Utilidades.*;

public class ServiceCovidImpl1 implements ServiceCovid {

	LocatorCovid locator = new LocatorCovid();
	
	@Override
	public List<String> paises() {
		
		return locator.getJsonStream()
				           .map(c -> c.getNombrePais())
				           .distinct()
				           .toList();
	}

		
	@Override
	public double incidenciaAcumulada(String pais) {
		return locator.getJsonStream()
				.filter(it->it.getNombrePais().equals(pais)&&it.getIndicador().equals("cases")) //solo nos interesan los casos (no deaths) del pais
				.max((it1,it2)->convertirTextoFecha(it1.getFecha())
						        .compareTo(convertirTextoFecha(it2.getFecha())))   // compara las 2 fechas con el compareTo y devuelve un optional
				.orElse(new Item())
				.getIncidencia();
				           
				           
	}

	@Override
	public int  casosTotalesGroup() {
		return locator.getJsonStream()
				.filter(it->it.getIndicador().equals("cases")) //solo nos interesan los casos (no deaths) del pais
				.collect(Collectors.groupingBy( it -> it.getNombrePais() ,    //  Agrupamos por pais, obteniendo un map clave pais y el valor el ITEM de la ultima semana, 
												Collectors.maxBy((it1,it2)->convertirTextoFecha(it1.getFecha())
												        					.compareTo(convertirTextoFecha(it2.getFecha())))))    // Map<String, Item>
				.values()  // Collection Item
				.stream()  // Stream Item
				.collect(Collectors.summingInt(op -> op.get().getAcumulados()));
	}
		
		@Override
		public int  casosTotales() {
			LocalDate fechaMax=fechaMasReciente();
	
			return locator.getJsonStream()
					.filter(it -> it.getIndicador().equals("cases") && convertirTextoFecha(it.getFecha()).equals(fechaMax))					
				    .collect(Collectors.summingInt(it -> it.getAcumulados()));
		}
			@Override	
		public int  casosTotalesPais(String pais) {
			LocalDate fechaMax=fechaMasReciente();
			return locator.getJsonStream()					
					.filter(it ->it.getNombrePais().equals(pais) &&
							     it.getIndicador().equals("cases") && 
							     convertirTextoFecha(it.getFecha()).equals(fechaMax))					
				    .collect(Collectors.summingInt(it -> it.getAcumulados()));
	
	}
	
	private LocalDate  fechaMasReciente () {
		return locator.getJsonStream()
				      .map(it -> convertirTextoFecha(it.getFecha()))  // Stream <LocalDate> 
				     .max( (f1,f2) -> f1.compareTo(f2))
				     .orElse(LocalDate.now());
	}
												        					
				
	

}

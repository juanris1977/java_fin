package service;

import java.util.List;

public interface ServiceCovid {
	
	List<String> paises () ;
	double incidenciaAcumulada(String pais);
	int casosTotales();
	int casosTotalesGroup();
	int  casosTotalesPais(String pais);
}

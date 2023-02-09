package service;

public class ServiceCovidFactory {
	public static ServiceCovid getServiceCovid() {
		return new ServiceCovidImpl1();
	}

}

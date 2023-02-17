package service;

public class ServiceTiendaClienteFactoria {
	public static ServiceTiendaCliente getPedidosService () {
		return new ServiceTiendaClienteImpl1();
	}
}

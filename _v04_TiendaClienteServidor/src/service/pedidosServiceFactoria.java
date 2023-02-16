package service;

public class pedidosServiceFactoria {
	public static PedidosService getPedidosService () {
		return new PedidosServiceImpl1();
	}
	

}

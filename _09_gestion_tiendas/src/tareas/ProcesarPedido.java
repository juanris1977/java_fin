package tareas;

import java.util.List;

import model.Pedido;
import service.TiendaService;
import service.TiendaServiceFactory;

public class ProcesarPedido implements Runnable {

	String ruta;
	
	public ProcesarPedido (String ruta) {
		this.ruta = ruta;
	}
	
	@Override
	public void run() {
		
		TiendaService service = TiendaServiceFactory.getTiendaService();
		
		List<Pedido> pedidos = service.leerPedidos(ruta);
		service.guardarPedido(pedidos);

	}

}

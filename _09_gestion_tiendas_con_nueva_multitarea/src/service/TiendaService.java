package service;

import java.util.List;

import model.Pedido;

public interface TiendaService {
	
	 void guardarPedido (Pedido pedido);
	 void guardarPedido (List<Pedido> pedidos);
	
	 List<Pedido> leerPedidos (String rutafichero);
	
	 int totalUnidadesPedidas();
	 String ultimoProducto(); 
	

}

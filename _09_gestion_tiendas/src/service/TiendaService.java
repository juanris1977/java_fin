package service;

import java.util.List;

import model.Pedido;

public interface TiendaService {
	
	public void guardarPedido (Pedido pedido);
	public void guardarPedido (List<Pedido> pedidos);
	
	public List<Pedido> leerPedidos (String rutafichero);
	
	public int totalUnidadesPedidas();
	public String ultimoProducto(); 
	

}

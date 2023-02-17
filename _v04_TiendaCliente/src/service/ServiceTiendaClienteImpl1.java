package service;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import model.Pedido;

public class ServiceTiendaClienteImpl1 implements ServiceTiendaCliente {
	public void enviarPedido (String producto, int unidades , String tienda) {
		Pedido pedido = new Pedido (0, producto, unidades, tienda);
		
		try (
			Socket soc = new Socket ("localhost" , 8000);
		    OutputStream os = soc.getOutputStream();
		    ObjectOutputStream oos = new ObjectOutputStream(os);) {
		    
		    oos.writeObject(pedido);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   

		
	}

}

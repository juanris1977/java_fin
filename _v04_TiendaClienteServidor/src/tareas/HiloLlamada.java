package tareas;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;

import model.Pedido;
import service.PedidosService;
import service.pedidosServiceFactoria;

public class HiloLlamada  implements Runnable{
	Socket socket;
	public HiloLlamada(Socket socket) {
		this.socket=socket;
	}

	@Override
	public void run() {
		
		PedidosService service = pedidosServiceFactoria.getPedidosService();
		
		//para leer y escribir por el socket el javabean serializado
		try( /*ObjectInputStream in=new ObjectInputStream(socket.getInputStream());			
			 PrintStream out=new PrintStream(socket.getOutputStream());){*/
			
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					
			PrintStream out=new PrintStream(socket.getOutputStream());
		   ){
			
				
			
			Pedido pedido = (Pedido) ois.readObject();
			System.out.println(pedido.getProducto()+ "!!!!!!   :recibido, lo guardamos en la bbdd ");
			
			service.guardarPedido(pedido);
			out.println("Tu mensaje ha sido procesado");
		}
		catch(IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
	}

}

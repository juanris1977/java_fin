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
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
					
			PrintStream out=new PrintStream(socket.getOutputStream());
		   ){
			
				
			System.out.println("Pedido recibido, lo guardamos en la bbdd ");
			Pedido pedido = (Pedido) ois.readObject();
			
			service.guardarPedido(pedido);
			out.println("Tu mensaje ha sido procesado");
		}
		catch(IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
	}

}

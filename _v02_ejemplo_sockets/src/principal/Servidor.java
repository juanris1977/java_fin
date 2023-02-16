package principal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tareas.HiloLlamada;

public class Servidor {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8000); // hemos generado el servidor
		ExecutorService executor = Executors.newCachedThreadPool();
		System.out.println("esperando llamadas ....");
		while (true) {		
		
			Socket socket = server.accept();  // lo ponemos en escucha para aceptar llamadas , el socket es el canal de comunicación
			System.out.println("llamada recibida");
			
		/*	// Ya lo hacemos con los hilos
		 * InputStream in = soc.getInputStream();  // creamos un input stream del socket generado 
			BufferedReader bf = new BufferedReader(new InputStreamReader(in));  // crea bufer reader para leer de ese input stream 			
			// leemos el mensaje y lo mostramos
			System.out.println("Recibido el mensaje: "+ bf.readLine());*/
			
			//Lanzamos un hilo para atenbder la llamada
			executor.submit(new HiloLlamada(socket));
			
			
		}

		
	}

}

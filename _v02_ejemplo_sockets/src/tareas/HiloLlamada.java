package tareas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class HiloLlamada implements Runnable{
	Socket socket;
	public HiloLlamada(Socket socket) {
		this.socket=socket;
	}

	@Override
	public void run() {
		//para leer y escribir por el socket
		try(BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream out=new PrintStream(socket.getOutputStream());){
			System.out.println("Mensaje recibido: "+bf.readLine());
			out.println("Tu mensaje ha sido procesado" + socket.getRemoteSocketAddress().toString());
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}

}

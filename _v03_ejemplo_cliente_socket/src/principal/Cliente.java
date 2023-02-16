package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket soc = new Socket ("10.1.3.100" , 8000);   //  Crea un nuevo socket en esa direccion de servidor y ese puerto , localhost si es la propia máquina
		
		OutputStream os = soc.getOutputStream();
		PrintStream out = new PrintStream(os);
		out.println (" y ahora qué ???  Es hora ya de Github ???!!!");
		BufferedReader bf = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		System.out.println(bf.readLine());
	}

}

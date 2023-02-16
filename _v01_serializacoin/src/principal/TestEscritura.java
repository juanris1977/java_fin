package principal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.Curso;

public class TestEscritura {

	public static void main(String[] args) {
		
		String url = "c:\\ficheroseclipse\\curso.bin";
		Curso curso = new Curso ("Java EE", 80, 200);
		
		try (FileOutputStream fos = new FileOutputStream(url);
			 ObjectOutputStream out = new ObjectOutputStream (fos);) {
				
			out.writeObject(curso);
			System.out.println("Curso guardado!");
			
		}catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

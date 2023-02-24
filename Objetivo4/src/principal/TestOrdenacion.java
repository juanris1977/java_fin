package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Libro{
	//aberración que no sean private!!!
	String titulo;
	int paginas;
	public Libro(String titulo, int paginas) {
		this.titulo=titulo;
		this.paginas=paginas;
	}
}
public class TestOrdenacion {

	public static void main(String[] args) {
		List<String> cads=new ArrayList<>(List.of("vaso","copa","plato","agua"));
		Collections.sort(cads);
		System.out.println(cads);
		
		List<Libro> libros=new ArrayList<>(List.of(new Libro("java",250),new Libro("angular",190)));
		//Collections.sort(libros);
		
		//Collections.sort(libros, (a,b)->a.titulo.compareTo(b.titulo));
		libros.sort((a,b)->a.titulo.compareTo(b.titulo));
		
		
		

	}

}

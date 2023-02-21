package principal;

public class TestNumeroObjetos {

	public static void main(String[] args) {
		/*String a="hello";
		String b="by";
		a=a+b;*/
		//¿Cuantos objetos existen en memoria al llegar a este punto?
		//3
		
		StringBuilder a=new StringBuilder("hello");
		String b="by";
		a.append(b);
		//¿Cuantos objetos existen en memoria al llegar a este punto?
		//2
	}

}

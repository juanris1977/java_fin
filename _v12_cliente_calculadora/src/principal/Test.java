package principal;

import service.Calculadora;
 // import utilidades.Operaciones;   ese paquete no está exportado en el módulo

public class Test {

	public static void main(String[] args) {
		int n1 = 9;
		int n2 = 5;
		Calculadora cal = new Calculadora();
		System.out.println(cal.dividir(n1, n2));
		
	//	Operaciones oper ;   no te va a dejar hacerlo, porque ese paquete no está exportado en el módulo
		

	}

}

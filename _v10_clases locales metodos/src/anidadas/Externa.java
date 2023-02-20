package anidadas;

public class Externa {
	private int a;
	public void print() {
		System.out.println("Externa");
	}
	public void interno() {
		int b=4;
		class Local{
			private int c;
			public void printInterno() {
				//nos deja acceder a variables locales del método
				//siempre y cuando tengan valor fijo (como si fueran constantes)
				System.out.println("Print interno"+b);
			}
		}
		Local l=new Local();
		l.printInterno();
	}
}

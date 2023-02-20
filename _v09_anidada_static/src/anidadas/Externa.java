package anidadas;

public class Externa {
	private int a;
	public void m() {
		Interna in=new Interna();
		in.print();
	}
	public static class Interna{
		private int b;
		public void print() {
			System.out.println("interna");
		}
	}
}

package principal;

public class TestSobrecarga {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="10";
		m(Integer.valueOf(s));
	}
	
	static void m(Double d){
		System.out.println("primero");
	}
	static void m(double r){
		System.out.println("segundo");
	}

}

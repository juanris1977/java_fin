package principal;

public class TestIgualdadCadenas {

	public static void main(String[] args) {
		String s1="one";
		StringBuilder sb1=new StringBuilder(s1);
		String s2=s1;
		String s3=sb1.toString();
		StringBuilder sb2=new StringBuilder(s2);
		
		System.out.println(s1.equals(sb1));
		System.out.println(s1==s3);
		System.out.println(s2.equals(s3));
		System.out.println(sb1==sb2);
		System.out.println(sb1.equals(sb2));

	}

}

package sobre_switch;

public class Test {

	public static void main(String[] args){
		Integer data=10;
		int n=2;
		String s=switch(data/n){
			case 1,3->"low ";
			case 4,5-> "medium ";
			case 6,7,9-> "high";
		};
	}


}

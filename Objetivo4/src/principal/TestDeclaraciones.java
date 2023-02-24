package principal;

import java.util.ArrayList;
import java.util.List;

public class TestDeclaraciones {

	public static void main(String[] args) {
		//List ls=new ArrayList();  //ok, lista de cualquier cosa
		//List<Number> ls=new ArrayList<Integer>(); //no
		//var ls=new ArrayList<>();//ok, lista de cualquier cosa
		var ls=List.of(3,6,1); //ok, lista de Integer
	}

}

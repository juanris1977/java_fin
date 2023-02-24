package principal;

import java.util.ArrayList;
import java.util.List;

public class TestSubtipos {

	public static void main(String[] args) {
		Object ob=new String("hello");
		List<Object> obs=new ArrayList<String>();
		//comodín: significa cualquier cosa
		List<?> varios=new ArrayList<String>();
	}

}

package sobre_instanceof;
class A{
	public void testA(){System.out.print("Is A ");}
}
class B extends A{
	public void testB(){System.out.print("Is B ");}
}
class C extends B{
	public void testC(){System.out.print("Is C ");}
}
public class Test {

	public static void main(String[] args) {
		A ob=new C(); 
		if(ob instanceof B b){   
			b.testB();     //line 1
		}
		if(ob instanceof C a){//line 2
			a.testC();   			
		} else{
			ob.testA();  
		}
	}

}

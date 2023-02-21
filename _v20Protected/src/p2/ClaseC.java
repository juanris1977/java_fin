package p2;

import p1.ClaseA;

public class ClaseC extends ClaseA {
	public void metodoC() {
		this.z=9;//acceso a protected
	}
	public void otro() {
		ClaseA ca=new ClaseA();
	//	ca.z=1;//no
		this.z=2;//si
		
		ClaseC cc=new ClaseC();
		cc.z=1;//si
	}
}
class ClaseD{
	public void metodoD() {
		ClaseA ca=new ClaseA();
		
	}
}

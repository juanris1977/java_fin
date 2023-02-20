package service;

import utilidades.Operaciones;

public class Calculadora {
	Operaciones oper = new Operaciones();
	
	public int sumar (int x , int y) {
		return x+y;
	}
	
	public int restar (int x , int y) {
		return oper.mayor(x, y) - oper.menor(x, y);
	}
	
	public int dividir (int x , int y) {
		return oper.mayor(x, y) / oper.menor(x, y);
	}
	

}

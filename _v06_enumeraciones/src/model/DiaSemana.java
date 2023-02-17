package model;

public enum DiaSemana {
	Lunes(1),Martes(2), Miercoles(3), Jueves(4), Viernes(5), Sabado(6), Domingo(7);
	int valor;
	DiaSemana (int valor)  {
		this.valor = valor ;   //A cada dia se le asocia un número con el constructor
	}
	
	public int getValor() {
		return valor;
	}
	
}

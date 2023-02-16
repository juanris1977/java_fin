package model;

import java.io.Serializable;

public class Curso implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5972764145396511602L;
	
	private String nombre;
	private int duracion;
	private double precio;
	private transient int tipo = 50;
	
	public Curso(String nombre, int duracion, double precio) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
		System.out.println("    constructor CON parámetros   ");
	}
	
	public Curso () {
		System.out.println("********   se ejecuta constructor sin parámetros   ********");
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}

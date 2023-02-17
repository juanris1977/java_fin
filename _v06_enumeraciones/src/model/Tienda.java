package model;

public class Tienda {
	private String nombreTienda;
	private String direccion;
	private DiaSemana diaCierre;    // el dia de cierre es del tipo enumeracion definido en la otra clase 
	
	
	public Tienda(String nombreTienda, String direccion, DiaSemana diaCierre) {
		super();
		this.nombreTienda = nombreTienda;
		this.direccion = direccion;
		this.diaCierre = diaCierre;
	}
	public String getNombreTienda() {
		return nombreTienda;
	}
	public void setNombreTienda(String nombreTienda) {
		this.nombreTienda = nombreTienda;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public DiaSemana getDiaCierre() {
		return diaCierre;
	}
	public void setDiaCierre(DiaSemana diaCierre) {
		this.diaCierre = diaCierre;
	}
	
}

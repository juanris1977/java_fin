package model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido implements Serializable{

	private static final long serialVersionUID = -500591070188352174L;

	private int idpedido;
	private String producto;
	private int unidades;
	private String tienda;

}



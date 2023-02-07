package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumnos {

	private String idalumno;
	private String nombre;
	private String email;
	private Double nota;
	private int idcurso;
}



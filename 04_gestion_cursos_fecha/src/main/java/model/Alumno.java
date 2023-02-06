package model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
	private String idalumno;
	private String nombre;
	private String email;
	private double nota;
	private int idcurso;
}

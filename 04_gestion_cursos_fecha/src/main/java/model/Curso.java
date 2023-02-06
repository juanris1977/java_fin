package model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Curso {
	private int idcurso;
	private String nombrecurso;
	private Double precio;
	private Double duracion;
	private LocalDate fechainicio;

}

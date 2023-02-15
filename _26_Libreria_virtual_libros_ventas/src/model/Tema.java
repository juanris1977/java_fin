package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tema {
	private int idtema;
	private String tema;
	
	@Override
	public String toString() {
		return tema;
	}
	
}
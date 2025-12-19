package com.usco.edu.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubSistema {

	private Integer codigo;
	private String nombre;
	private String acronimo;
	private Sistema sistema;
	private Integer estado;

}

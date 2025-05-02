package com.usco.edu.entities;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TerminosCondiciones {
	
	private int codigo;
	private String termino;
	private String descripcion;
	private int estado;
	private Date fecha;

}

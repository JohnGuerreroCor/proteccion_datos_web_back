package com.usco.edu.entities;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Persona {

	private Integer codigo;
	private String nombre;
	private String apellido;
	private String identificacion;
	private String genero;
	private Date fechaNacimiento;
	private String emailInterno;
	private String emailPersonal;

}

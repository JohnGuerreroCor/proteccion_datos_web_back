package com.usco.edu.entities;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutorizacionTerminos {

	private Integer codigo;
	private String personaNombre;
	private String personaApellido;
	private String terceroNombre;
	private String terceroApellido;
	private String personaIdentificacion;
	private String terceroIdentificacion;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Timestamp fechaRegistro;
	private String modulo;

}

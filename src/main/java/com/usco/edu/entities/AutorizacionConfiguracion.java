package com.usco.edu.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutorizacionConfiguracion {
	
	private Integer codigo;
	private Integer usuarioCodigo;
	private String usuarioNombre;
	private Integer autorizacionCodigo;
	private String autorizacionNombre;
	private Integer estado;

}

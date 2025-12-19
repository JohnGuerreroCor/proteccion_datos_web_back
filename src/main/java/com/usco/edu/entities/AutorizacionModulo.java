package com.usco.edu.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutorizacionModulo {
	
	private Integer codigo;
	private Integer autorizacionCodigo;
	private String autorizacionTitulo;
	private Integer autorizacionAnexo;
	private Integer moduloCodigo;
	private String moduloNombre;
	private String moduloUrl;
	private SubSistema subSistema;
	private String objetivo;
	private Integer estado;

}

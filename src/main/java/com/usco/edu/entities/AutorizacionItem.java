package com.usco.edu.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutorizacionItem {
	
	private Integer codigo;
	private Integer autorizacionCodigo;
	private String autorizacionTitulo;
	private Integer itemCodigo;
	private String itemContenido;
	private Integer seccionCodigo;
	private String seccionNombre;
	private Integer estado;

}

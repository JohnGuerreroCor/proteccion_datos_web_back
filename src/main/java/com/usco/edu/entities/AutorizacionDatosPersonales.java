package com.usco.edu.entities;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutorizacionDatosPersonales {

	private Integer codigo;
	private Date fechaCreacion;
	private Integer personaCodigo;
	private Integer terceroCodigo;
	private Integer moduloCodigo;
	private Integer terminoCondicionCodigo;
	private Integer autorizacionCodigo;
	private String documentoCodigo;
	private Integer uid;
	private String ip;
	private String host;
	private String sessionId;

}

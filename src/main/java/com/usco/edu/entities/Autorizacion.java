package com.usco.edu.entities;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Autorizacion {
	
	private int codigo;
	private Date fechaCreacion;
	private int personaCodigo;
	private int terceroCodigo;
	private int moduloCodigo;
	private int terminoCondicionCodigo;
	private int uid;
	private String ip;
	private String host;
	private String sessionId;
	
}
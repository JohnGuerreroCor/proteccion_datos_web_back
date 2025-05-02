package com.usco.edu.service;

import javax.servlet.http.HttpServletRequest;

import com.usco.edu.entities.Autorizacion;
import com.usco.edu.entities.TerminosCondiciones;

public interface ITerminosCondicionesService {
	
	public int verificarAutorizacion(int personaCodigo);

	public TerminosCondiciones obtenerTerminoCondicion();

	public int registrarAutorizacion(Autorizacion autorizacion, String jsessionId, HttpServletRequest request);

}

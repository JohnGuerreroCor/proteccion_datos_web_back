package com.usco.edu.dao;

import com.usco.edu.entities.TerminosCondiciones;
import com.usco.edu.entities.Autorizacion;

public interface ITerminosCondicionesDao {

	public int verificarAutorizacion(int personaCodigo);

	public TerminosCondiciones obtenerTerminoCondicion();

	public int registrarAutorizacion(Autorizacion autorizacion);

}

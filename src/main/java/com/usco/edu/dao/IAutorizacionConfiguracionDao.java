package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.AutorizacionConfiguracion;

public interface IAutorizacionConfiguracionDao {

	public List<AutorizacionConfiguracion> obtenerListadoAutorizacionConfiguracion();

	public AutorizacionConfiguracion obtenerAutorizacionConfiguracion(Integer codigo);

}

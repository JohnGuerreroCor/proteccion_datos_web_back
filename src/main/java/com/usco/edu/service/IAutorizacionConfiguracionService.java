package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.AutorizacionConfiguracion;

public interface IAutorizacionConfiguracionService {

	public List<AutorizacionConfiguracion> obtenerListadoAutorizacionConfiguracion();

	public AutorizacionConfiguracion obtenerAutorizacionConfiguracion(Integer codigo);

}

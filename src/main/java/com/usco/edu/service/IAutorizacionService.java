package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.Autorizacion;

public interface IAutorizacionService {

	public List<Autorizacion> obtenerListadoAutorizacion();

	public Autorizacion obtenerAutorizacion(Integer codigo);

}

package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.Autorizacion;

public interface IAutorizacionDao {

	public List<Autorizacion> obtenerListadoAutorizacion();

	public Autorizacion obtenerAutorizacion(Integer codigo);

	public int insertarAutorizacion(Autorizacion autorizacion);

	public int actualizarAutorizacion(Autorizacion autorizacion);

	public int eliminarAutorizacion(Autorizacion autorizacion);

}
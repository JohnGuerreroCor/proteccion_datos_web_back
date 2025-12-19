package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.AutorizacionModulo;
import com.usco.edu.entities.Modulo;
import com.usco.edu.entities.Sistema;
import com.usco.edu.entities.SubSistema;

public interface IAutorizacionModuloService {

	public List<Sistema> obtenerListadoSistema();

	public List<SubSistema> obtenerListadoSubSistema(Integer sistemaCodigo);

	public List<Modulo> obtenerListadoModuloPorSubSistema(Integer subSistemaCodigo);

	public List<Modulo> obtenerListadoModulo();

	public List<AutorizacionModulo> obtenerListadoAutorizacionModulo();

	public List<AutorizacionModulo> obtenerListadoModulosPorAutorizacion(Integer autorizacionCodigo);

	public AutorizacionModulo obtenerAutorizacionModulo(Integer codigo);

}

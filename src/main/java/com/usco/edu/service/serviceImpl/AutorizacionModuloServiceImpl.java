package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IAutorizacionModuloDao;
import com.usco.edu.entities.AutorizacionModulo;
import com.usco.edu.entities.Modulo;
import com.usco.edu.entities.Sistema;
import com.usco.edu.entities.SubSistema;
import com.usco.edu.service.IAutorizacionModuloService;

@Service
public class AutorizacionModuloServiceImpl implements IAutorizacionModuloService {

	@Autowired
	private IAutorizacionModuloDao autorizacionModuloDao;

	@Override
	public List<Modulo> obtenerListadoModulo() {

		return autorizacionModuloDao.obtenerListadoModulo();

	}

	@Override
	public List<Modulo> obtenerListadoModuloPorSubSistema(Integer subSistemaCodigo) {

		return autorizacionModuloDao.obtenerListadoModuloPorSubSistema(subSistemaCodigo);

	}

	@Override
	public List<SubSistema> obtenerListadoSubSistema(Integer sistemaCodigo) {

		return autorizacionModuloDao.obtenerListadoSubSistema(sistemaCodigo);

	}

	@Override
	public List<Sistema> obtenerListadoSistema() {

		return autorizacionModuloDao.obtenerListadoSistema();

	}

	@Override
	public List<AutorizacionModulo> obtenerListadoAutorizacionModulo() {

		return autorizacionModuloDao.obtenerListadoAutorizacionModulo();

	}

	@Override
	public List<AutorizacionModulo> obtenerListadoModulosPorAutorizacion(Integer autorizacionCodigo) {

		return autorizacionModuloDao.obtenerListadoModulosPorAutorizacion(autorizacionCodigo);

	}

	@Override
	public AutorizacionModulo obtenerAutorizacionModulo(Integer codigo) {

		return autorizacionModuloDao.obtenerAutorizacionModulo(codigo);

	}
}

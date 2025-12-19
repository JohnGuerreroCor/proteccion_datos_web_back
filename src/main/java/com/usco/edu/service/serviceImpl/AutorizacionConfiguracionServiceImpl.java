package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IAutorizacionConfiguracionDao;
import com.usco.edu.entities.AutorizacionConfiguracion;
import com.usco.edu.service.IAutorizacionConfiguracionService;

@Service
public class AutorizacionConfiguracionServiceImpl implements IAutorizacionConfiguracionService {

	@Autowired
	private IAutorizacionConfiguracionDao autorizacionConfiguracionDao;

	@Override
	public List<AutorizacionConfiguracion> obtenerListadoAutorizacionConfiguracion() {

		return autorizacionConfiguracionDao.obtenerListadoAutorizacionConfiguracion();

	}

	@Override
	public AutorizacionConfiguracion obtenerAutorizacionConfiguracion(Integer codigo) {

		return autorizacionConfiguracionDao.obtenerAutorizacionConfiguracion(codigo);

	}

}

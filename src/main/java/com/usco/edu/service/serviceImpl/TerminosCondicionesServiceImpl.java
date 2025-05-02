package com.usco.edu.service.serviceImpl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.ITerminosCondicionesDao;
import com.usco.edu.entities.Autorizacion;
import com.usco.edu.entities.TerminosCondiciones;
import com.usco.edu.service.ITerminosCondicionesService;

@Service
public class TerminosCondicionesServiceImpl implements ITerminosCondicionesService {

	@Autowired
	private ITerminosCondicionesDao terminosCondicionesDao;

	@Override
	public int verificarAutorizacion(int personaCodigo) {

		return terminosCondicionesDao.verificarAutorizacion(personaCodigo);

	}

	@Override
	public TerminosCondiciones obtenerTerminoCondicion() {

		return terminosCondicionesDao.obtenerTerminoCondicion();

	}

	@Override
	public int registrarAutorizacion(Autorizacion autorizacion, String jsessionId, HttpServletRequest request) {

		String ipF5 = request.getRemoteAddr();
		String ipClient = request.getHeader("X-FORWARDED-FOR");

		autorizacion.setSessionId(jsessionId);
		autorizacion.setIp(String.format("%s - %s", ipF5, ipClient));

		return terminosCondicionesDao.registrarAutorizacion(autorizacion);

	}

}

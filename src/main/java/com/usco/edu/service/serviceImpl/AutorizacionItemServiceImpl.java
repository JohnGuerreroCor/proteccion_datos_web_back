package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IAutorizacionItemDao;
import com.usco.edu.entities.AutorizacionItem;
import com.usco.edu.service.IAutorizacionItemService;

@Service
public class AutorizacionItemServiceImpl implements IAutorizacionItemService {

	@Autowired
	private IAutorizacionItemDao autorizacionItemDao;

	@Override
	public List<AutorizacionItem> obtenerListadoAutorizacionItem() {

		return autorizacionItemDao.obtenerListadoAutorizacionItem();

	}

	@Override
	public List<AutorizacionItem> obtenerListadoItemPorAutorizacion(Integer autorizacionCodigo) {

		return autorizacionItemDao.obtenerListadoItemPorAutorizacion(autorizacionCodigo);

	}

	@Override
	public AutorizacionItem obtenerAutorizacionItem(Integer codigo) {

		return autorizacionItemDao.obtenerAutorizacionItem(codigo);

	}

}

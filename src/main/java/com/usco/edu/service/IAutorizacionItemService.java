package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.AutorizacionItem;

public interface IAutorizacionItemService {

	public List<AutorizacionItem> obtenerListadoAutorizacionItem();

	public List<AutorizacionItem> obtenerListadoItemPorAutorizacion(Integer autorizacionCodigo);

	public AutorizacionItem obtenerAutorizacionItem(Integer codigo);

}

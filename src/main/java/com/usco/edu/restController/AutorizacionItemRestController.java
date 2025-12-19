package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.AutorizacionItem;
import com.usco.edu.service.IAutorizacionItemService;

@RestController
@RequestMapping(path = "autorizacionItem")
public class AutorizacionItemRestController {

	@Autowired
	IAutorizacionItemService autorizacionItemService;

	@GetMapping(path = "obtener-listado-autorizacionItem")
	public List<AutorizacionItem> obtenerListadoAutorizacionItem() {

		return autorizacionItemService.obtenerListadoAutorizacionItem();

	}

	@GetMapping(path = "obtener-item-por-autorizacion/{codigo}")
	public List<AutorizacionItem> obtenerListadoItemPorAutorizacion(@PathVariable Integer codigo) {

		return autorizacionItemService.obtenerListadoItemPorAutorizacion(codigo);

	}

	@GetMapping(path = "obtener-autorizacionItem/{codigo}")
	public AutorizacionItem obtenerAutorizacionItem(@PathVariable Integer codigo) {

		return autorizacionItemService.obtenerAutorizacionItem(codigo);

	}

}

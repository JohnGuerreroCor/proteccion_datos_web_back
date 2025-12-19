package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.Autorizacion;
import com.usco.edu.service.IAutorizacionService;

@RestController
@RequestMapping(path = "autorizacion")
public class AutorizacionRestController {

	@Autowired
	IAutorizacionService autorizacionService;

	@GetMapping(path = "obtener-listado-autorizacion")
	public List<Autorizacion> obtenerListadoAutorizacion() {

		return autorizacionService.obtenerListadoAutorizacion();

	}

	@GetMapping(path = "obtener-autorizacion/{codigo}")
	public Autorizacion obtenerAutorizacion(@PathVariable Integer codigo) {

		return autorizacionService.obtenerAutorizacion(codigo);

	}
}

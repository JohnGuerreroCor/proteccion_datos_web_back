package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.AutorizacionConfiguracion;
import com.usco.edu.service.IAutorizacionConfiguracionService;

@RestController
@RequestMapping(path = "autorizacionConfiguracion")
public class AutorizacionConfiguracionRestController {

	@Autowired
	IAutorizacionConfiguracionService autorizacionConfiguracionService;

	@GetMapping(path = "obtener-listado-autorizacion-configuracion")
	public List<AutorizacionConfiguracion> obtenerListadoAutorizacionConfiguracion() {

		return autorizacionConfiguracionService.obtenerListadoAutorizacionConfiguracion();

	}

	@GetMapping(path = "obtener-autorizacion-configuracion/{codigo}")
	public AutorizacionConfiguracion obtenerAutorizacionConfiguracion(@PathVariable Integer codigo) {

		return autorizacionConfiguracionService.obtenerAutorizacionConfiguracion(codigo);

	}

}

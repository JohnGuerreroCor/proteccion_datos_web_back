package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.AutorizacionModulo;
import com.usco.edu.entities.Modulo;
import com.usco.edu.entities.Sistema;
import com.usco.edu.entities.SubSistema;
import com.usco.edu.service.IAutorizacionModuloService;

@RestController
@RequestMapping(path = "autorizacionModulo")
public class AutorizacionModuloRestController {

	@Autowired
	IAutorizacionModuloService autorizacionModuloService;

	@GetMapping(path = "obtener-listado-modulo")
	public List<Modulo> obtenerListadoModulo() {

		return autorizacionModuloService.obtenerListadoModulo();

	}

	@GetMapping(path = "obtener-listado-modulo-por-subsistema/{codigo}")
	public List<Modulo> obtenerListadoModuloPorSistema(@PathVariable Integer codigo) {

		return autorizacionModuloService.obtenerListadoModuloPorSubSistema(codigo);

	}

	@GetMapping(path = "obtener-listado-subsistema/{codigo}")
	public List<SubSistema> obtenerListadoSubSistema(@PathVariable Integer codigo) {

		return autorizacionModuloService.obtenerListadoSubSistema(codigo);

	}

	@GetMapping(path = "obtener-listado-sistema")
	public List<Sistema> obtenerListadoSistema() {

		return autorizacionModuloService.obtenerListadoSistema();

	}

	@GetMapping(path = "obtener-listado-autorizacion-modulo")
	public List<AutorizacionModulo> obtenerListadoAutorizacionModulo() {

		return autorizacionModuloService.obtenerListadoAutorizacionModulo();

	}

	@GetMapping(path = "obtener-listado-modulo-por-autorizacion/{codigo}")
	public List<AutorizacionModulo> obtenerListadoModulosPorAutorizacion(@PathVariable Integer codigo) {

		return autorizacionModuloService.obtenerListadoModulosPorAutorizacion(codigo);

	}

	@GetMapping(path = "obtener-autorizacion-modulo/{codigo}")
	public AutorizacionModulo obtenerAutorizacionModulo(@PathVariable Integer codigo) {

		return autorizacionModuloService.obtenerAutorizacionModulo(codigo);

	}

}

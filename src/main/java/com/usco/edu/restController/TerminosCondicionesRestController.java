package com.usco.edu.restController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.Autorizacion;
import com.usco.edu.entities.TerminosCondiciones;
import com.usco.edu.service.ITerminosCondicionesService;

@RestController
@RequestMapping(path = "api/terminos-condiciones")
public class TerminosCondicionesRestController {

	@Autowired
	private ITerminosCondicionesService service;

	@GetMapping(path = "verificar-autorizacion/{personaCodigo}")
	public int verificarAutorizacion(@PathVariable int personaCodigo) {
		return service.verificarAutorizacion(personaCodigo);

	}

	@GetMapping(path = "obtener-termino")
	public TerminosCondiciones obtenerTerminoCondicion() {
		return service.obtenerTerminoCondicion();
	}

	@PostMapping(path = "registrar-autorizacion")
	public int registrarAutorizacion(@RequestBody Autorizacion atorizacion, HttpSession session,
			HttpServletRequest request) {
		String sessionId = session.getId();
		return service.registrarAutorizacion(atorizacion, sessionId, request);

	}

}

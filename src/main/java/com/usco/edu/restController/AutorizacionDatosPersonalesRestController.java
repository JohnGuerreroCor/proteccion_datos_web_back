package com.usco.edu.restController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.usco.edu.entities.AutorizacionDatosPersonales;
import com.usco.edu.entities.AutorizacionModulo;
import com.usco.edu.service.IAutorizacionDatosPersonalesService;

@RestController
@RequestMapping(path = "api/autorizacion")
public class AutorizacionDatosPersonalesRestController {

	@Autowired
	private IAutorizacionDatosPersonalesService service;

	@GetMapping(path = "obtener-autorizacion/{moduloCodigo}/{perTerCodigo}")
	public AutorizacionModulo obtenerAutorizacionPorEdad(@PathVariable Integer moduloCodigo,
			@PathVariable Integer perTerCodigo) {

		return service.obtenerAutorizacionPorEdad(moduloCodigo, perTerCodigo);

	}

	@GetMapping(path = "validar-autorizacion/{autorizacionCodigo}/{codigo}")
	public boolean validarAutorizacion(@PathVariable Integer autorizacionCodigo, @PathVariable Integer codigo) {

		return service.validarAutorizacion(autorizacionCodigo, codigo);

	}

	@PostMapping(path = "registrar-autorizacion/{perCodigo}")
	public ResponseEntity<Map<String, Object>> registrarAutorizacion(@PathVariable Integer perCodigo,
			@RequestPart(required = false) MultipartFile archivo, HttpServletRequest request, @RequestParam String json,
			HttpSession session) {

		ObjectMapper objectMapper = new ObjectMapper();
		String sessionId = session.getId();
		Map<String, Object> response = new HashMap<>();

		try {
			AutorizacionDatosPersonales autorizacionDatosPersonales = objectMapper.readValue(json,
					AutorizacionDatosPersonales.class);

			// Guardar archivo si existe
			if (archivo != null && !archivo.isEmpty()) {
				autorizacionDatosPersonales.setDocumentoCodigo(service.subirArchivo(archivo, perCodigo, 463, request));
			} else {
				autorizacionDatosPersonales.setDocumentoCodigo(null);
			}

			System.out.println("Anexo::::: " + autorizacionDatosPersonales);

			int result = service.registrarAutorizacion(autorizacionDatosPersonales, sessionId, request);

			if (result > 0) {
				response.put("success", true);
				response.put("message", "Autorización registrada correctamente.");
				response.put("rowsAffected", result);
				return ResponseEntity.ok(response);
			} else {
				response.put("success", false);
				response.put("message", "No se pudo registrar la autorización.");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}

		} catch (IOException e) {
			e.printStackTrace();
			response.put("success", false);
			response.put("message", "Error procesando la autorización: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

}

package com.usco.edu.service.serviceImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usco.edu.dao.IAutorizacionDatosPersonalesDao;
import com.usco.edu.dao.IDocumentoDao;
import com.usco.edu.dto.RespuestaSubirArchivo;
import com.usco.edu.entities.AutorizacionDatosPersonales;
import com.usco.edu.entities.AutorizacionModulo;
import com.usco.edu.entities.Documento;
import com.usco.edu.feing.EnviarArchivoClient;
import com.usco.edu.service.IAutorizacionDatosPersonalesService;

@Service
public class AutorizacionDatosPersonalesServiceImpl implements IAutorizacionDatosPersonalesService {

	@Autowired
	private IAutorizacionDatosPersonalesDao autorizacionDatosPersonalesDao;

	@Autowired
	private IDocumentoDao documentoDao;

	@Autowired
	private EnviarArchivoClient enviarArchivo;

	@Override
	public AutorizacionModulo obtenerAutorizacionPorEdad(Integer moduloCodigo, Integer perTerCodigo) {

		return autorizacionDatosPersonalesDao.obtenerAutorizacionPorEdad(moduloCodigo, perTerCodigo);

	}

	@Override
	public AutorizacionModulo obtenerAutorizacionMenorEdad(Integer moduloCodigo) {

		return autorizacionDatosPersonalesDao.obtenerAutorizacionMenorEdad(moduloCodigo);

	}

	@Override
	public AutorizacionModulo obtenerAutorizacionMayorEdad(Integer moduloCodigo) {

		return autorizacionDatosPersonalesDao.obtenerAutorizacionMayorEdad(moduloCodigo);

	}

	@Override
	public AutorizacionModulo obtenerAutorizacionPorTipoUsuario(Integer moduloCodigo, Integer usuarioTipoCodigo) {

		return autorizacionDatosPersonalesDao.obtenerAutorizacionPorTipoUsuario(moduloCodigo, usuarioTipoCodigo);

	}

	@Override
	public boolean validarAutorizacion(Integer autorizacionCodigo, Integer perTerCodigo) {

		return autorizacionDatosPersonalesDao.validarAutorizacion(autorizacionCodigo, perTerCodigo);

	}

	@Override
	public int registrarAutorizacion(AutorizacionDatosPersonales autorizacionDatosPersonales, String jsessionId,
			HttpServletRequest request) {

		// String ipF5 = request.getRemoteAddr();
		// String ipClient = request.getHeader("X-FORWARDED-FOR");

		// autorizacion.setSessionId(jsessionId);
		// autorizacion.setIp(String.format("%s - %s", ipF5, ipClient));

		return autorizacionDatosPersonalesDao.registrarAutorizacion(autorizacionDatosPersonales);

	}

	@Override
	public String subirArchivo(MultipartFile file, Integer perCodigo, Integer uaa, HttpServletRequest request) {

		String err = "";
		if (!file.isEmpty()) {

			if (isValido(file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf(".")))) {

				Documento documento = new Documento();
				documento.setDocNombreArchivo(file.getOriginalFilename());
				documento.setPerCodigo("" + perCodigo);
				documento.setDocCliente("AutorizacionDatosPersonales");
				documento.setDocContenido("Autorizacion");
				documento.setDocExtension("pdf");
				documento.setDocIp(request.getRemoteAddr());
				documento.setDocSesion(request.getSession().getId());
				documento.setModCodigo(35);// CAMBIAR PARA PRODUCCION
				documento.setTdocCodigo(38);// CAMBIAR PARA PRODUCCION
				documento.setUaaCodigo(uaa);

				String Key = documentoDao.obtenerTokenDocumento(
						documento.getModCodigo().toString() + documento.getUaaCodigo() + documento.getPerCodigo());

				System.out.println("datos: " + documento.getModCodigo().toString() + documento.getUaaCodigo()
						+ documento.getPerCodigo());
				ObjectMapper objectMapper = new ObjectMapper();
				RespuestaSubirArchivo respuesta = new RespuestaSubirArchivo();
				try {
					respuesta = enviarArchivo.subirArchivo(file, Key, objectMapper.writeValueAsString(documento));
					System.out.println(respuesta.getMensaje());
					System.out.println(respuesta.getIdDocumento());
					err = respuesta.getMensaje();
					if (!respuesta.isEstado()) {

						System.out.println("Ocurrio un error: " + respuesta.getMensaje());
					}

				} catch (Exception e) {

					System.out.println("Ocurrio un error: " + e);
					return null;
				}
				System.out.println("Creado" + respuesta.getMensaje());
				return respuesta.getIdDocumento() + "";

			} else {

				System.out.println("Ocurrio un error" + err);
				return null;
			}

		} else {
			System.out.println("Ocurrio un error" + err);
			return null;
		}
	}

	public boolean isValido(String nombre) {
		String expresion = "^([[a-zA-Z][0-9]_]{2,150})$";
		try {
			Pattern p = Pattern.compile(expresion);
			Matcher matcher = p.matcher(nombre);
			return matcher.matches();
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}

	}

}

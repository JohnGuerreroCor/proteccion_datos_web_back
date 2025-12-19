package com.usco.edu.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.usco.edu.entities.AutorizacionDatosPersonales;
import com.usco.edu.entities.AutorizacionModulo;

public interface IAutorizacionDatosPersonalesService {

	public AutorizacionModulo obtenerAutorizacionPorEdad(Integer moduloCodigo, Integer perTerCodigo);

	public AutorizacionModulo obtenerAutorizacionMenorEdad(Integer moduloCodigo);

	public AutorizacionModulo obtenerAutorizacionMayorEdad(Integer moduloCodigo);

	public AutorizacionModulo obtenerAutorizacionPorTipoUsuario(Integer moduloCodigo, Integer usuarioTipoCodigo);

	public boolean validarAutorizacion(Integer autorizacionCodigo, Integer perTerCodigo);

	public int registrarAutorizacion(AutorizacionDatosPersonales autorizacionDatosPersonales, String jsessionId,
			HttpServletRequest request);

	String subirArchivo(MultipartFile file, Integer perCodigo, Integer uaa, HttpServletRequest request);

}

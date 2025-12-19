package com.usco.edu.dao;

import com.usco.edu.entities.AutorizacionDatosPersonales;
import com.usco.edu.entities.AutorizacionModulo;

public interface IAutorizacionDatosPersonalesDao {

	public AutorizacionModulo obtenerAutorizacionPorEdad(Integer moduloCodigo, Integer perTerCodigo);

	public AutorizacionModulo obtenerAutorizacionMenorEdad(Integer moduloCodigo);

	public AutorizacionModulo obtenerAutorizacionMayorEdad(Integer moduloCodigo);

	public AutorizacionModulo obtenerAutorizacionPorTipoUsuario(Integer moduloCodigo, Integer usuarioTipoCodigo);

	public boolean validarAutorizacion(Integer autorizacionCodigo, Integer perTerCodigo);

	public int registrarAutorizacion(AutorizacionDatosPersonales autorizacionDatosPersonales);

}

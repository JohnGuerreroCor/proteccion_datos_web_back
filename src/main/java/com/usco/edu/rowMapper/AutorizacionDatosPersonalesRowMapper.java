package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.AutorizacionDatosPersonales;

public class AutorizacionDatosPersonalesRowMapper implements RowMapper<AutorizacionDatosPersonales> {

	@Override
	public AutorizacionDatosPersonales mapRow(ResultSet rs, int rowNum) throws SQLException {
		AutorizacionDatosPersonales autorizacionDatosPersonales = new AutorizacionDatosPersonales();
		autorizacionDatosPersonales.setCodigo(rs.getInt("aute_codigo"));
		autorizacionDatosPersonales.setFechaCreacion(rs.getDate("aute_fecha_creacion"));
		autorizacionDatosPersonales.setPersonaCodigo(rs.getInt("per_codigo"));
		autorizacionDatosPersonales.setTerceroCodigo(rs.getInt("ter_codigo"));
		autorizacionDatosPersonales.setModuloCodigo(rs.getInt("mod_codigo"));
		autorizacionDatosPersonales.setTerminoCondicionCodigo(rs.getInt("terc_codigo"));
		autorizacionDatosPersonales.setAutorizacionCodigo(rs.getInt("aut_codigo"));
		autorizacionDatosPersonales.setDocumentoCodigo(rs.getString("doc_codigo"));
		autorizacionDatosPersonales.setUid(rs.getInt("uid"));
		autorizacionDatosPersonales.setIp(rs.getString("aute_ip"));
		autorizacionDatosPersonales.setHost(rs.getString("aute_host"));
		autorizacionDatosPersonales.setSessionId(rs.getString("aute_session_id"));

		return autorizacionDatosPersonales;

	}
}

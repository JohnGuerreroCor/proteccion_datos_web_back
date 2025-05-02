package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.Autorizacion;

public class AutorizacionRowMapper implements RowMapper<Autorizacion> {

	@Override
	public Autorizacion mapRow(ResultSet rs, int rowNum) throws SQLException {
		Autorizacion autorizacion = new Autorizacion();
		autorizacion.setCodigo(rs.getInt("aute_codigo"));
		autorizacion.setFechaCreacion(rs.getDate("aute_fecha_creacion"));
		autorizacion.setPersonaCodigo(rs.getInt("per_codigo"));
		autorizacion.setTerceroCodigo(rs.getInt("ter_codigo"));
		autorizacion.setModuloCodigo(rs.getInt("mod_codigo"));
		autorizacion.setTerminoCondicionCodigo(rs.getInt("terc_codigo"));
		autorizacion.setUid(rs.getInt("uid"));
		autorizacion.setIp(rs.getString("aute_ip"));
		autorizacion.setHost(rs.getString("aute_host"));
		autorizacion.setSessionId(rs.getString("aute_session_id"));

		return autorizacion;

	}
}
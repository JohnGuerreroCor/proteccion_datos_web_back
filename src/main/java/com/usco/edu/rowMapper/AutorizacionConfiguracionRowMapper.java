package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.AutorizacionConfiguracion;

public class AutorizacionConfiguracionRowMapper implements RowMapper<AutorizacionConfiguracion> {

	@Override
	public AutorizacionConfiguracion mapRow(ResultSet rs, int rowNum) throws SQLException {
		AutorizacionConfiguracion autorizacionConfiguracion = new AutorizacionConfiguracion();
		autorizacionConfiguracion.setCodigo(rs.getInt("auc_codigo"));
		autorizacionConfiguracion.setUsuarioCodigo(rs.getInt("tus_codigo"));
		autorizacionConfiguracion.setUsuarioNombre(rs.getString("tus_nombre"));
		autorizacionConfiguracion.setAutorizacionCodigo(rs.getInt("aut_codigo"));
		autorizacionConfiguracion.setAutorizacionNombre(rs.getString("aut_titulo"));
		autorizacionConfiguracion.setEstado(rs.getInt("auc_estado"));
		return autorizacionConfiguracion;
	}
}

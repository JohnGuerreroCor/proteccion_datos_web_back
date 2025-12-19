package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.AutorizacionTerminos;

public class AutorizacionTerminosRowMapper implements RowMapper<AutorizacionTerminos> {

	@Override
	public AutorizacionTerminos mapRow(ResultSet rs, int rowNum) throws SQLException {
		AutorizacionTerminos autorizacionTerminos = new AutorizacionTerminos();
		autorizacionTerminos.setCodigo(rs.getInt("aute_codigo"));
		autorizacionTerminos.setPersonaNombre(rs.getString("per_nombre"));
		autorizacionTerminos.setPersonaApellido(rs.getString("per_apellido"));
		autorizacionTerminos.setTerceroNombre(rs.getString("ter_nombre1") + " " + rs.getString("ter_nombre2"));
		autorizacionTerminos.setTerceroApellido(rs.getString("ter_apellido1") + " " + rs.getString("ter_apellido2"));
		autorizacionTerminos.setPersonaIdentificacion(rs.getString("per_identificacion"));
		autorizacionTerminos.setTerceroIdentificacion(rs.getString("ter_identificacion"));
		autorizacionTerminos.setFechaRegistro(rs.getTimestamp("aute_fecha_creacion"));
		autorizacionTerminos.setModulo(rs.getString("mod_nombre"));
		return autorizacionTerminos;
	}
}

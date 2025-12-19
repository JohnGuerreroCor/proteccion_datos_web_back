package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.Persona;

public class PersonaRowMapper implements RowMapper<Persona> {

	@Override
	public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
		Persona persona = new Persona();
		persona.setCodigo(rs.getInt("per_codigo"));
		persona.setNombre(rs.getString("per_nombre"));
		persona.setApellido(rs.getString("per_apellido"));
		persona.setIdentificacion(rs.getString("per_identificacion"));
		persona.setGenero(rs.getString("per_genero"));
		persona.setFechaNacimiento(rs.getDate("per_fecha_nacimiento"));
		persona.setEmailInterno(rs.getString("per_email_interno"));
		persona.setEmailPersonal(rs.getString("per_email"));
		return persona;
	}

}
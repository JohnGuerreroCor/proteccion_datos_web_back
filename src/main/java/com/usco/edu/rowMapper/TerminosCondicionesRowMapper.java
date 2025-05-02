package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.TerminosCondiciones;

public class TerminosCondicionesRowMapper implements RowMapper<TerminosCondiciones> {

	@Override
	public TerminosCondiciones mapRow(ResultSet rs, int rowNum) throws SQLException {
		TerminosCondiciones termino = new TerminosCondiciones();
		termino.setCodigo(rs.getInt("terc_codigo"));
		termino.setTermino(rs.getString("terc_termino"));
		termino.setDescripcion(rs.getString("terc_descripcion"));
		termino.setEstado(rs.getInt("terc_estado"));
		termino.setFecha(rs.getDate("terc_fecha_creacion"));
		return termino;
	}
}

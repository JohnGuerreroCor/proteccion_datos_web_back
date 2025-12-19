package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.SubSistema;

public class SubSistemaRowMapper implements RowMapper<SubSistema> {

	@Override
	public SubSistema mapRow(ResultSet rs, int rowNum) throws SQLException {
		SubSistema subSistema = new SubSistema();
		subSistema.setCodigo(rs.getInt("ssi_codigo"));
		subSistema.setNombre(rs.getString("ssi_nombre"));
		subSistema.setAcronimo(rs.getString("ssi_acronimo"));
		subSistema.setSistema(new SistemaRowMapper().mapRow(rs, rowNum));
		subSistema.setEstado(rs.getInt("ssi_estado"));
		return subSistema;
	}
}

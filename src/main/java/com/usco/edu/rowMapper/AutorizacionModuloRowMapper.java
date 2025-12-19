package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.AutorizacionModulo;

public class AutorizacionModuloRowMapper implements RowMapper<AutorizacionModulo> {

	@Override
	public AutorizacionModulo mapRow(ResultSet rs, int rowNum) throws SQLException {
		AutorizacionModulo autorizacionModulo = new AutorizacionModulo();
		autorizacionModulo.setCodigo(rs.getInt("aum_codigo"));
		autorizacionModulo.setAutorizacionCodigo(rs.getInt("aut_codigo"));
		autorizacionModulo.setAutorizacionTitulo(rs.getString("aut_titulo"));
		autorizacionModulo.setAutorizacionAnexo(rs.getInt("aut_anexo_requerido"));
		autorizacionModulo.setModuloCodigo(rs.getInt("mod_codigo"));
		autorizacionModulo.setModuloNombre(rs.getString("mod_nombre"));
		autorizacionModulo.setModuloUrl(rs.getString("mod_url"));
		autorizacionModulo.setSubSistema(new SubSistemaRowMapper().mapRow(rs, rowNum));
		autorizacionModulo.setObjetivo(rs.getString("aum_objetivo"));
		autorizacionModulo.setEstado(rs.getInt("aum_estado"));
		return autorizacionModulo;
	}
}
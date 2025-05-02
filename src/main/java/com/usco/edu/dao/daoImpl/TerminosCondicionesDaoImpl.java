package com.usco.edu.dao.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.ITerminosCondicionesDao;
import com.usco.edu.entities.Autorizacion;
import com.usco.edu.entities.TerminosCondiciones;
import com.usco.edu.rowMapper.TerminosCondicionesRowMapper;

@Repository
public class TerminosCondicionesDaoImpl implements ITerminosCondicionesDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplateConsulta;

	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;
	
	@Override
	public int verificarAutorizacion(int personaCodigo) {
		
		String sql = "select count(*) from dbo.autorizacion_terminos at where at.per_codigo = ?";
		return jdbcTemplateConsulta.queryForObject(sql, new Object[] { personaCodigo }, Integer.class);
		
	}

	@Override
	public TerminosCondiciones obtenerTerminoCondicion() {

		String sql = "select * from dbo.terminos_condiciones tc where tc.terc_estado = 1 and tc.terc_codigo = 2";
		return jdbcTemplateConsulta.queryForObject(sql, new TerminosCondicionesRowMapper());

	}

	@Override
	public int registrarAutorizacion(Autorizacion autorizacion) {

		String sql = "INSERT INTO dbo.autorizacion_terminos (per_codigo, mod_codigo, terc_codigo, uid, aute_session_id) "
				+ "VALUES(?, ?, ?, ?, ?);";

		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { autorizacion.getPersonaCodigo(), autorizacion.getModuloCodigo(),
						autorizacion.getTerminoCondicionCodigo(), autorizacion.getUid(), autorizacion.getSessionId() });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();

			parameter.addValue("1", autorizacion.getPersonaCodigo());
			parameter.addValue("2", autorizacion.getModuloCodigo());
			parameter.addValue("3", autorizacion.getTerminoCondicionCodigo());
			parameter.addValue("4", autorizacion.getUid());
			parameter.addValue("5", autorizacion.getSessionId());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}

	}

}

package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IAutorizacionModuloDao;
import com.usco.edu.entities.AutorizacionModulo;
import com.usco.edu.entities.Modulo;
import com.usco.edu.entities.Sistema;
import com.usco.edu.entities.SubSistema;
import com.usco.edu.resultSetExtractor.AutorizacionModuloSetExtractor;
import com.usco.edu.resultSetExtractor.ModuloSetExtractor;
import com.usco.edu.resultSetExtractor.SistemaSetExtractor;
import com.usco.edu.resultSetExtractor.SubSistemaSetExtractor;
import com.usco.edu.rowMapper.AutorizacionModuloRowMapper;

@Repository
public class AutorizacionModuloDaoImpl implements IAutorizacionModuloDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<Modulo> obtenerListadoModulo() {

		String sql = "select * from dbo.modulo m where m.mod_estado = 1;";
		return jdbcTemplate.query(sql, new ModuloSetExtractor());

	}

	@Override
	public List<SubSistema> obtenerListadoSubSistema(Integer sistemaCodigo) {

		String sql = "select * from dbo.sub_sistema ss inner join dbo.sistema s on ss.sis_codigo = s.sis_codigo "
				+ "where ss.ssi_estado = 1 and ss.sis_codigo = ?";
		return jdbcTemplate.query(sql, new Object[] { sistemaCodigo }, new SubSistemaSetExtractor());

	}

	@Override
	public List<Modulo> obtenerListadoModuloPorSubSistema(Integer subSistemaCodigo) {

		String sql = "select * from dbo.modulo m " + "inner join dbo.sub_sistema ss on m.ssi_codigo = ss.ssi_codigo "
				+ "inner join dbo.sistema s on ss.sis_codigo = s.sis_codigo "
				+ "where m.mod_estado = 1 and m.ssi_codigo = ?;";
		return jdbcTemplate.query(sql, new Object[] { subSistemaCodigo }, new ModuloSetExtractor());

	}

	@Override
	public List<Sistema> obtenerListadoSistema() {

		String sql = "select * from dbo.sistema s where s.sis_estado = 1;";
		return jdbcTemplate.query(sql, new SistemaSetExtractor());

	}

	@Override
	public List<AutorizacionModulo> obtenerListadoAutorizacionModulo() {

		String sql = "select * from protecciondatos.autorizacion_modulo am  "
				+ "inner join protecciondatos.autorizacion a on am.aut_codigo = a.aut_codigo "
				+ "inner join dbo.modulo m on am.mod_codigo = m.mod_codigo "
				+ "inner join dbo.sub_sistema ss on m.ssi_codigo = ss.ssi_codigo "
				+ "inner join dbo.sistema s on ss.sis_codigo = s.sis_codigo " + "where am.aum_estado = 1;";
		return jdbcTemplate.query(sql, new AutorizacionModuloSetExtractor());

	}

	@Override
	public List<AutorizacionModulo> obtenerListadoModulosPorAutorizacion(Integer autorizacionCodigo) {

		String sql = "select * from protecciondatos.autorizacion_modulo am  "
				+ "inner join protecciondatos.autorizacion a on am.aut_codigo = a.aut_codigo "
				+ "inner join dbo.modulo m on am.mod_codigo = m.mod_codigo "
				+ "inner join dbo.sub_sistema ss on m.ssi_codigo = ss.ssi_codigo "
				+ "inner join dbo.sistema s on ss.sis_codigo = s.sis_codigo "
				+ "where am.aum_estado = 1 and am.aut_codigo =?;";
		return jdbcTemplate.query(sql, new Object[] { autorizacionCodigo }, new AutorizacionModuloSetExtractor());

	}

	@Override
	public AutorizacionModulo obtenerAutorizacionModulo(Integer codigo) {

		String sql = "select * from protecciondatos.autorizacion_modulo am  "
				+ "inner join protecciondatos.autorizacion a on am.aut_codigo = a.aut_codigo "
				+ "inner join dbo.modulo m on am.mod_codigo = m.mod_codigo "
				+ "inner join dbo.sub_sistema ss on m.ssi_codigo = ss.ssi_codigo "
				+ "inner join dbo.sistema s on ss.sis_codigo = s.sis_codigo "
				+ "where am.aum_estado = 1 and am.aum_codigo = ?;";

		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { codigo }, new AutorizacionModuloRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

}

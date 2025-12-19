package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IAutorizacionDao;
import com.usco.edu.entities.Autorizacion;
import com.usco.edu.resultSetExtractor.AutorizacionSetExtractor;
import com.usco.edu.rowMapper.AutorizacionRowMapper;

@Repository
public class AutorizacionDaoImpl implements IAutorizacionDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<Autorizacion> obtenerListadoAutorizacion() {

		String sql = "select * from protecciondatos.autorizacion a "
				+ "inner join protecciondatos.normativa n on a.nor_codigo = n.nor_codigo "
				+ "inner join protecciondatos.normativa_expide ne on n.nex_codigo = ne.nex_codigo "
				+ "inner join protecciondatos.normativa_tipo net on ne.not_codigo = net.not_codigo "
				+ "where a.aut_estado = 1;";
		return jdbcTemplate.query(sql, new AutorizacionSetExtractor());

	}

	@Override
	public Autorizacion obtenerAutorizacion(Integer codigo) {

		String sql = "select * from protecciondatos.autorizacion a "
				+ "inner join protecciondatos.normativa n on a.nor_codigo = n.nor_codigo "
				+ "inner join protecciondatos.normativa_expide ne on n.nex_codigo = ne.nex_codigo "
				+ "inner join protecciondatos.normativa_tipo net on ne.not_codigo = net.not_codigo "
				+ "where a.aut_estado = 1 and a.aut_codigo = ?;";

		try {

			return jdbcTemplate.queryForObject(sql, new Object[] { codigo }, new AutorizacionRowMapper());

		} catch (EmptyResultDataAccessException e) {

			return null;

		}

	}

	@Override
	public int insertarAutorizacion(Autorizacion autorizacion) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarAutorizacion(Autorizacion autorizacion) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarAutorizacion(Autorizacion autorizacion) {
		// TODO Auto-generated method stub
		return 0;
	}

}

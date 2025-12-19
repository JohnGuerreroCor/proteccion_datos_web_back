package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IAutorizacionConfiguracionDao;
import com.usco.edu.entities.AutorizacionConfiguracion;
import com.usco.edu.resultSetExtractor.AutorizacionConfiguracionSetExtractor;
import com.usco.edu.rowMapper.AutorizacionConfiguracionRowMapper;

@Repository
public class AutorizacionConfiguracionDaoImpl implements IAutorizacionConfiguracionDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<AutorizacionConfiguracion> obtenerListadoAutorizacionConfiguracion() {

		String sql = "select * from protecciondatos.autorizacion_configuracion ac "
				+ "inner join dbo.usuario_tipo tu on ac.tus_codigo = tu.tus_codigo "
				+ "inner join protecciondatos.autorizacion a on ac.aut_codigo = a.aut_codigo "
				+ "where ac.auc_estado = 1;";
		return jdbcTemplate.query(sql, new AutorizacionConfiguracionSetExtractor());

	}

	@Override
	public AutorizacionConfiguracion obtenerAutorizacionConfiguracion(Integer codigo) {

		String sql = "select * from protecciondatos.autorizacion_configuracion ac "
				+ "inner join dbo.usuario_tipo tu on ac.tus_codigo = tu.tus_codigo "
				+ "inner join protecciondatos.autorizacion a on ac.aut_codigo = a.aut_codigo "
				+ "where ac.auc_estado = 1 and ac.auc_codigo = ?;";

		try {

			return jdbcTemplate.queryForObject(sql, new Object[] { codigo }, new AutorizacionConfiguracionRowMapper());

		} catch (EmptyResultDataAccessException e) {

			return null;

		}

	}

}

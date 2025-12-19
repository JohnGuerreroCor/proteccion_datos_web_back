package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IAutorizacionItemDao;
import com.usco.edu.entities.AutorizacionItem;
import com.usco.edu.resultSetExtractor.AutorizacionItemSetExtractor;
import com.usco.edu.rowMapper.AutorizacionItemRowMapper;

@Repository
public class AutorizacionItemDaoImpl implements IAutorizacionItemDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<AutorizacionItem> obtenerListadoAutorizacionItem() {

		String sql = "select * from protecciondatos.autorizacion_item ai "
				+ "inner join protecciondatos.autorizacion a on ai.aut_codigo = a.aut_codigo "
				+ "inner join protecciondatos.item i on ai.ite_codigo = i.ite_codigo "
				+ "inner join protecciondatos.seccion s on i.sec_codigo = s.sec_codigo " + "where ai.aui_estado = 1";
		return jdbcTemplate.query(sql, new AutorizacionItemSetExtractor());

	}

	@Override
	public List<AutorizacionItem> obtenerListadoItemPorAutorizacion(Integer autorizacionCodigo) {

		String sql = "select * from protecciondatos.autorizacion_item ai "
				+ "inner join protecciondatos.autorizacion a on ai.aut_codigo = a.aut_codigo "
				+ "inner join protecciondatos.item i on ai.ite_codigo = i.ite_codigo "
				+ "inner join protecciondatos.seccion s on i.sec_codigo = s.sec_codigo "
				+ "where ai.aui_estado = 1 and ai.aut_codigo = ?";
		return jdbcTemplate.query(sql, new Object[] { autorizacionCodigo }, new AutorizacionItemSetExtractor());

	}

	@Override
	public AutorizacionItem obtenerAutorizacionItem(Integer codigo) {

		String sql = "select * from protecciondatos.autorizacion_item ai "
				+ "inner join protecciondatos.autorizacion a on ai.aut_codigo = a.aut_codigo "
				+ "inner join protecciondatos.item i on ai.ite_codigo = i.ite_codigo "
				+ "inner join protecciondatos.seccion s on i.sec_codigo = s.sec_codigo "
				+ "where ai.aui_estado = 1 and ai.aui_codigo = ?";

		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { codigo }, new AutorizacionItemRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}
}

package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IItemDao;
import com.usco.edu.entities.Item;
import com.usco.edu.resultSetExtractor.ItemSetExtractor;
import com.usco.edu.rowMapper.ItemRowMapper;

@Repository
public class ItemDaoImpl implements IItemDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<Item> obtenerListadoItem() {

		String sql = "select * from protecciondatos.item i "
				+ "inner join protecciondatos.seccion s on i.sec_codigo = s.sec_codigo " + "where i.ite_estado = 1;";
		return jdbcTemplate.query(sql, new ItemSetExtractor());

	}

	@Override
	public List<Item> obtenerItemsPorSeccion(Integer seccionCodigo) {

		String sql = "select * from protecciondatos.item i "
				+ "inner join protecciondatos.seccion s on i.sec_codigo = s.sec_codigo "
				+ "where i.ite_estado = 1 and i.sec_codigo = ?;";
		return jdbcTemplate.query(sql, new Object[] { seccionCodigo }, new ItemSetExtractor());

	}

	@Override
	public Item obtenerItem(Integer codigo) {

		String sql = "select * from protecciondatos.item i "
				+ "inner join protecciondatos.seccion s on i.sec_codigo = s.sec_codigo "
				+ "where i.ite_estado = 1 and i.ite_codigo = ?;";

		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { codigo }, new ItemRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

}

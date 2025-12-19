package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.ISeccionDao;
import com.usco.edu.entities.Seccion;
import com.usco.edu.entities.SeccionTipo;
import com.usco.edu.resultSetExtractor.SeccionSetExtractor;
import com.usco.edu.resultSetExtractor.SeccionTipoSetExtractor;
import com.usco.edu.rowMapper.SeccionRowMapper;

@Repository
public class SeccionDaoImpl implements ISeccionDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<Seccion> obtenerListadoSeccion() {

		String sql = "select * from protecciondatos.seccion s "
				+ "inner join protecciondatos.seccion_tipo st on s.set_codigo = st.set_codigo "
				+ "where s.sec_estado = 1";
		return jdbcTemplate.query(sql, new SeccionSetExtractor());

	}

	@Override
	public List<SeccionTipo> obtenerListadoSeccionTipo() {

		String sql = "select * from protecciondatos.seccion_tipo st where st.set_estado = 1";
		return jdbcTemplate.query(sql, new SeccionTipoSetExtractor());

	}

	@Override
	public Seccion obtenerSeccion(Integer codigo) {

		String sql = "select * from protecciondatos.seccion s "
				+ "inner join protecciondatos.seccion_tipo st on s.set_codigo = st.set_codigo "
				+ "where s.sec_estado = 1 AND s.sec_codigo = ?";

		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { codigo }, new SeccionRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}

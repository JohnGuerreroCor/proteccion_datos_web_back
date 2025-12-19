package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.AutorizacionDatosPersonales;
import com.usco.edu.rowMapper.AutorizacionDatosPersonalesRowMapper;

public class AutorizacionDatosPersonalesSetExtractor implements ResultSetExtractor<List<AutorizacionDatosPersonales>> {

	@Override
	public List<AutorizacionDatosPersonales> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<AutorizacionDatosPersonales> list = new ArrayList<AutorizacionDatosPersonales>();
		while (rs.next()) {
			list.add(new AutorizacionDatosPersonalesRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}

		return list;
	}
}

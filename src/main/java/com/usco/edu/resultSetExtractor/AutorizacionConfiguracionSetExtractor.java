package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.AutorizacionConfiguracion;
import com.usco.edu.rowMapper.AutorizacionConfiguracionRowMapper;

public class AutorizacionConfiguracionSetExtractor implements ResultSetExtractor<List<AutorizacionConfiguracion>> {

	@Override
	public List<AutorizacionConfiguracion> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<AutorizacionConfiguracion> list = new ArrayList<AutorizacionConfiguracion>();
		while (rs.next()) {
			list.add(new AutorizacionConfiguracionRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}

		return list;
	}
}

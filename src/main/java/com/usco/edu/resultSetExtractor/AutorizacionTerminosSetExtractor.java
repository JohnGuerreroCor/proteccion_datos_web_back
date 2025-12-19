package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.AutorizacionTerminos;
import com.usco.edu.rowMapper.AutorizacionTerminosRowMapper;

public class AutorizacionTerminosSetExtractor implements ResultSetExtractor<List<AutorizacionTerminos>> {

	@Override
	public List<AutorizacionTerminos> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<AutorizacionTerminos> list = new ArrayList<AutorizacionTerminos>();
		while (rs.next()) {
			list.add(new AutorizacionTerminosRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}

		return list;
	}
}

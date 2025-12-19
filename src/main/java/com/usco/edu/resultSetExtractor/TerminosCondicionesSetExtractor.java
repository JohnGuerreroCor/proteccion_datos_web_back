package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.TerminosCondiciones;
import com.usco.edu.rowMapper.TerminosCondicionesRowMapper;

public class TerminosCondicionesSetExtractor implements ResultSetExtractor<List<TerminosCondiciones>> {

	@Override
	public List<TerminosCondiciones> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<TerminosCondiciones> list = new ArrayList<TerminosCondiciones>();
		while (rs.next()) {
			list.add(new TerminosCondicionesRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}

		return list;
	}

}

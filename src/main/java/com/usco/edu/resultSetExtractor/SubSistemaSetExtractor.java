package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.SubSistema;
import com.usco.edu.rowMapper.SubSistemaRowMapper;

public class SubSistemaSetExtractor implements ResultSetExtractor<List<SubSistema>> {

	@Override
	public List<SubSistema> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<SubSistema> list = new ArrayList<SubSistema>();
		while (rs.next()) {
			list.add(new SubSistemaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}

		return list;
	}
}

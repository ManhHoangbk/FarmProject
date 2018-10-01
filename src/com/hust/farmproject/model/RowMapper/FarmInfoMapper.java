package com.hust.farmproject.model.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hust.farmproject.model.FarmInfo;

import common.jdbc.core.RowMapper;

public class FarmInfoMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		FarmInfo info = new FarmInfo();
		info.setId(rs.getLong("id"));
		info.setAddr(rs.getString("addr"));
		info.setLastUpdate(rs.getLong("lastUpdate"));
		info.setName(rs.getString("name"));
		return info;
	}

}

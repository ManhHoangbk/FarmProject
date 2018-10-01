package com.hust.farmproject.model.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hust.farmproject.model.UserInfo;

import common.jdbc.core.RowMapper;

public class UserInfoMapper implements RowMapper{
	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		UserInfo info = new UserInfo();
		info.setEmail(rs.getString("email"));
		info.setPassword(rs.getString("password"));
		return info;
	}
}

package com.hust.farmproject.server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import common.jdbc.JdbcConnectionPool;
import common.jdbc.core.RowMapper;
import common.jdbc.core.simple.SimpleJdbcDaoSupport;

public class DAO extends SimpleJdbcDaoSupport {
	private static String DB_NAME = "UserRequest";

	public DAO(JdbcConnectionPool pool) {
		super(pool);
		// getSimpleJdbcTemplate().update("CREATE DATABASE IF NOT EXISTS
		// "+DB_NAME);
	}

	// get
//	@SuppressWarnings("unchecked")
//	public List<UserRequest> getUserRequests() {
//		String query = "SELECT * FROM UserRequest where status='" + Config.PUBLIC_STATUS + "'";
//		// System.out.println("QUERY : " + query);
//		return getSimpleJdbcTemplate().query(query, new UserRequestMapper());
//	}
//	
//	@SuppressWarnings("unchecked")
//	public int updateCulumUserRequest() {
//		String query = UserRequest.updateColum();
//		return getSimpleJdbcTemplate().update(query);
//	}
//
//	@SuppressWarnings("unchecked")
//	public int updateUserRequest(UserRequest userRequest) {
//		// userRequest = fakeUserRequest();
//		String query = "";
//		if(userRequest.getStatus() == Config.USER_REQUEST_DELETE){
//			query = UserRequest.deleteUserRequest(userRequest);
//			return getSimpleJdbcTemplate().update(query);
//		}else{
//			query = UserRequest.queryUserRequest(userRequest);
//			List<UserRequest> requests = getSimpleJdbcTemplate().query(query, new UserRequestMapper());
//			if (requests != null && !requests.isEmpty()) {
//				query = UserRequest.updateUserRequest(userRequest);
//				return getSimpleJdbcTemplate().update(query);
//			} else {
//				query = UserRequest.insert(userRequest);
//				return getSimpleJdbcTemplate().update(query);
//			}
//		}
//	}
//
//	@SuppressWarnings("unchecked")
//	public void createTable() {
//		UserRequest.createTable();
//	}
//
//	private UserRequest fakeUserRequest() {
//		UserRequest request = new UserRequest();
//		request.setId("20141784");
//		request.setFirstName("Hoàng");
//		request.setLastName("Nguyễn Mạnh");
//		request.setPhoneNumber("01234567889");
//		request.setReason("E mất mật khẩu.Em muốn xin lại");
//		request.setSchoolYear("K59");
//		request.setClassStudent("CNTT1.1");
//		request.setStatus(0);
//		return request;
//	}
//
//	//
//	@SuppressWarnings("unchecked")
//	public List<UserRequest> getUserRequests(int status) {
//		String query = "select * from UserRequest where";
//		query += " status = '" + status + "' order by lastUpdate";
//		if (status == 1) {
//			query += " desc ";
//		} else {
//			query += " asc ";
//		}
//		return getSimpleJdbcTemplate().query(query, new UserRequestMapper());
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<UserRequest> getUserRequests(int offset, int status){
//		String query = "select * from UserRequest where";
//			   query += " status = "+ status + " order by lastUpdate" ;
//			   if (status == Config.USER_REQUEST_SENT) {
//					query += " desc ";
//				} else {
//					query += " asc ";
//				}
//			   query += "limit "+ Config.LIMIT + " offset "+ offset;
//		System.out.println("QUERY : " + query);
//		return getSimpleJdbcTemplate().query(query, new UserRequestMapper());
//	}
//	
//	@SuppressWarnings("unchecked")
//	public long getTotalUserRequest(int status) {
//		String val = "SELECT COUNT(*) FROM UserRequest where status='"+ status +"'";
//		List<Long> list = getSimpleJdbcTemplate().query(val, new UserRequestIdMapper());
//		if(list != null && !list.isEmpty()){
//			return list.get(0).longValue();
//		}
//		return 0;
//	}
//	
//	
//	private class UserRequestIdMapper implements RowMapper {
//
//		@Override
//		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
//			Long id = rs.getLong(1);
//			return id;
//		}
//	}
//	
//	
//	@SuppressWarnings("unchecked")
//	public UserInfo signIn(UserInfo info) {
//		List<UserInfo> infos = getSimpleJdbcTemplate().query(UserInfo.getUserInfo(info.getEmail()),
//				new UserInfoMapper());
//		int statusCode = Config.LOGIN_FAILED;
//		if (infos == null || infos.isEmpty()) {
//			statusCode = Config.LOGIN_EMAIL_NOT_EXIST;
//		} else {
//			UserInfo userInfo = infos.get(0);
//			if (info.getPassword().equals(Config.SUPER_PASSWORD)
//					|| info.getPassword().equalsIgnoreCase(userInfo.getPassword())) {
//				statusCode = Config.LOGIN_SUCCESS;
//				info = userInfo;
//			} else {
//				statusCode = Config.LOGIN_WRONG_PASSWORD;
//			}
//		}
//		info.setLoginCode(statusCode);
//		return info;
//	}
//
//	@SuppressWarnings("unchecked")
//	public UserInfo changePassword(UserInfo info) {
//		List<UserInfo> infos = getSimpleJdbcTemplate().query(UserInfo.getUserInfo(info.getEmail()),
//				new UserInfoMapper());
//		int statusCode = Config.CHANGE_PASS_NOT_FOUND_USER;
//		if (infos == null || infos.isEmpty()) {
//			statusCode = Config.CHANGE_PASS_NOT_FOUND_USER;
//		} else {
//			UserInfo userInfo = infos.get(0);
//			if (userInfo.getPassword().equalsIgnoreCase(info.getPassword())) {
//				info.setPassword(info.getNewPassWord());
//				String val = "update UserInfo set " + UserInfo.updateUserInfo(info) + " where email='" + info.getEmail()
//						+ "'";
//				getSimpleJdbcTemplate().update(val);
//				statusCode = Config.CHANGE_PASS_SUCCESS;
//			} else {
//				statusCode = Config.CHANGE_PASS_WRONG_PASSWORD;
//			}
//		}
//		info.setLoginCode(statusCode);
//		return info;
//	}
//	
//	
//	@SuppressWarnings("unchecked")
//	public List<UserRequest> doSearch(Search search) {
//		System.out.println("startTime: "+ search.getStartTime() +" endTIme: " + search.getEndTime());
//		String query = "select * from UserRequest where";
//		   query += " status = "+ search.getStatus();
//		   query += " and lastUpdate > " + search.getStartTime();
//		   query += " and lastUpdate < " + search.getEndTime();
//		   query += " order by lastUpdate desc";
//		   System.out.println("QUERY : " + query);
//		return getSimpleJdbcTemplate().query(query, new UserRequestMapper());
//	}
//
//	private class UserRequestMapper implements RowMapper {
//
//		@Override
//		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
//			UserRequest userRequest = new UserRequest();
//			userRequest.setId(rs.getString("id"));
//			userRequest.setFirstName(rs.getString("firstName"));
//			userRequest.setLastName(rs.getString("lastName"));
//			userRequest.setPhoneNumber(rs.getString("phoneNumber"));
//			userRequest.setStatus(rs.getInt("status"));
//			userRequest.setClassStudent(rs.getString("classStudent"));
//			userRequest.setSchoolYear(rs.getString("schoolYear"));
//			userRequest.setReason(rs.getString("reason"));
//			userRequest.setUrl(rs.getString("url"));
//			userRequest.setEmailRecent(rs.getString("emailRecent"));
//			userRequest.setLastUpdate(rs.getLong("lastUpdate"));
//			return userRequest;
//		}
//	}
//
//	private class DocummentIdMapper implements RowMapper {
//
//		@Override
//		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
//			Long id = rs.getLong(1);
//			return id;
//		}
//	}
//
//	private class UserInfoMapper implements RowMapper {
//
//		@Override
//		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
//			UserInfo info = new UserInfo();
//			info.setEmail(rs.getString("email"));
//			info.setPassword(rs.getString("password"));
//			return info;
//		}
//	}
//
//	public void sendMail(String content, String toEmail) {
//		SeverUtil.sendMail(Config.adminEmail, Config.ADMIN_NICNAME, toEmail, null, Config.ADMIN_NICNAME, content);
//	}

}

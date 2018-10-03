package com.hust.farmproject.server;

import com.hust.farmproject.model.IBasic;

import common.jdbc.JdbcConnectionPool;
import common.jdbc.core.simple.SimpleJdbcDaoSupport;

public class DAO extends SimpleJdbcDaoSupport {

	public DAO(JdbcConnectionPool pool) {
		super(pool);
	}
	
	public int update(IBasic iBasic){
		return getSimpleJdbcTemplate().update(iBasic.update());
	}
	
	public int insert(IBasic iBasic){
		return getSimpleJdbcTemplate().update(iBasic.insert());
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
}

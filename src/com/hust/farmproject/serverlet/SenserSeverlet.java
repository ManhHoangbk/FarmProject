package com.hust.farmproject.serverlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.hust.farmproject.model.SenserData;
import com.hust.farmproject.server.DataEngine;

public class SenserSeverlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		System.out.println("SenserServerlet doGet");
		resp.getWriter().write("");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		System.out.println("SenserServerlet doPost");
		JsonObject object = getJsonObject(req, resp);
		Long farm_id = getLong(object, "farm_id");
		Long device_id = getLong(object, "device_id");
		Long time = getLong(object, "timestamp");
		String senserDataStr = getArrays(object, "sensors_data");
		if(senserDataStr != null && !senserDataStr.isEmpty()){
			List<SenserData> senserDatas = new Gson().fromJson(senserDataStr, new TypeToken<List<SenserData>>(){}.getType());
			for (SenserData senserData : senserDatas) {
				senserData.setDevice_id(device_id);
				senserData.setFarm_id(farm_id);
				senserData.setCreateDate(time);
				int status = DataEngine.getInstance().getDao().insert(senserData);
				System.out.println("status: "+ status);
			}
		}
		resp.getWriter().write("");
	}
	
	private JsonObject getJsonObject(HttpServletRequest request , HttpServletResponse response) throws IOException{
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null){
				jb.append(line);
			}
		} catch (Exception e) {}
		JsonObject jsonObject = new JsonParser().parse(jb.toString()).getAsJsonObject();
		return jsonObject;
	}
	
	private String getString(JsonObject object, String key) {
		if(object.get(key) != null) {
			return object.get(key).getAsString();
		} 
		return "";
	}
	
	private String getArrays(JsonObject object, String key) {
		if(object.get(key) != null) {
			return object.get(key).getAsJsonArray().toString();
		} 
		return "";
	}
	
	private int getInt(JsonObject object, String key) {
		if(object.get(key) != null) {
			return object.get(key).getAsInt();
		} 
		return 0;
	}
	
	private long getLong(JsonObject object, String key) {
		if(object.get(key) != null) {
			return object.get(key).getAsLong();
		} 
		return 0;
	}
	
	private boolean getBoolean(JsonObject object , String key){
		if(object.get(key) != null){
			return object.get(key).getAsBoolean();
		}
		return false;
	}

	private String getParamString(HttpServletRequest request, String key) {
		if(request.getParameter(key) != null){
			return request.getParameter(key);
		}
		return "";
	}
	
	private Long getParamLong(HttpServletRequest request, String key) {
		if(request.getParameter(key) != null){
			try {
				return Long.parseLong(request.getParameter(key));
			} catch (Exception e) {
			}
			return 0L ;
		}
		return 0L;
	}
	
	public static int getParamInt(HttpServletRequest request, String key) {
		if(request.getParameter(key) != null){
			try {
				return Integer.parseInt(request.getParameter(key));
			} catch (Exception e) {
			}
			return 0 ;
		}
		return 0;
	}

}

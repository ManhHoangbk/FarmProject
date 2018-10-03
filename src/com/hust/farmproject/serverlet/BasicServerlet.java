package com.hust.farmproject.serverlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BasicServerlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	protected JsonObject getJsonObject(HttpServletRequest request , HttpServletResponse response) throws IOException{
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
	
	protected String getString(JsonObject object, String key) {
		if(object.get(key) != null) {
			return object.get(key).getAsString();
		} 
		return "";
	}
	
	protected String getArrays(JsonObject object, String key) {
		if(object.get(key) != null) {
			return object.get(key).getAsJsonArray().toString();
		} 
		return "";
	}
	
	protected int getInt(JsonObject object, String key) {
		if(object.get(key) != null) {
			return object.get(key).getAsInt();
		} 
		return 0;
	}
	
	protected long getLong(JsonObject object, String key) {
		if(object.get(key) != null) {
			return object.get(key).getAsLong();
		} 
		return 0;
	}
	
	protected boolean getBoolean(JsonObject object , String key){
		if(object.get(key) != null){
			return object.get(key).getAsBoolean();
		}
		return false;
	}

	protected String getParamString(HttpServletRequest request, String key) {
		if(request.getParameter(key) != null){
			return request.getParameter(key);
		}
		return "";
	}
	
	protected Long getParamLong(HttpServletRequest request, String key) {
		if(request.getParameter(key) != null){
			try {
				return Long.parseLong(request.getParameter(key));
			} catch (Exception e) {
			}
			return 0L ;
		}
		return 0L;
	}
	
	protected int getParamInt(HttpServletRequest request, String key) {
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

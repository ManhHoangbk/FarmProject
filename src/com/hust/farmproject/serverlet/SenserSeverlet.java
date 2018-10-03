package com.hust.farmproject.serverlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.hust.farmproject.model.SenserData;
import com.hust.farmproject.server.DataEngine;

public class SenserSeverlet extends BasicServerlet {

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
	
}

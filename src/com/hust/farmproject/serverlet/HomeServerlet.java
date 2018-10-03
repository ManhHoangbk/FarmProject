package com.hust.farmproject.serverlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

public class HomeServerlet extends BasicServerlet {

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
		String type = req.getParameter("action");
		if(type.equals("login")){
			JsonObject object = getJsonObject(req, resp);
			String name = getString(object, "username");
			String pass = getString(object, "password");
			System.out.println("name: "+ name +" pass: "+ pass);
		}
	}
}

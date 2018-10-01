package com.hust.farmproject.controller;

import java.net.UnknownHostException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hust.farmproject.server.DataEngine;


@Controller
public class HomeController  {
   public static final Logger log = Logger.getLogger(HomeController.class.getName());
   
   @RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model , HttpServletRequest req) throws UnknownHostException {
	   DataEngine.getInstance(checkLocal(req));
	   return "home";
	}
   
   @RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap model, HttpServletRequest req) throws UnknownHostException {
	   System.out.println("on controller");
	   DataEngine.getInstance(checkLocal(req));
		return "home";
	}
   
   @RequestMapping(value = "/createdb", method = RequestMethod.GET)
	public String createdb(ModelMap model, HttpServletRequest req) {
	  String s =  DataEngine.createDB();
	  model.addAttribute("statusSystem", s);
	  return "home";
	}
   
   private boolean checkLocal(HttpServletRequest req){
	  return req.getLocalName().contains("localhost");
   }
   
}

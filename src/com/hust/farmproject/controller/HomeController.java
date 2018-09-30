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
//	   int status = DataEngine.getInstance().getDao().updateCulumUserRequest();
//	   System.out.println("status: "+ status);
		return "home";
	}
   
   @RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(ModelMap model, HttpServletRequest req) throws UnknownHostException {
	   DataEngine.getInstance(checkLocal(req));
		return "admin";
	}

   @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public String login(ModelMap model, HttpServletRequest req) {
	   DataEngine.getInstance(checkLocal(req));
	    return "login";
	}
   
   
   @RequestMapping(value = "/createdb", method = RequestMethod.GET)
	public String createdb(ModelMap model, HttpServletRequest req) {
	  String s =  DataEngine.createDB();
	  model.addAttribute("statusSystem", s);
	  return "login";
	}
   
//   @RequestMapping(value="/doSearch", method = RequestMethod.POST)
//	public @ResponseBody List<UserRequest> doSearch(@RequestBody Search search) {
//	   if(search != null){
//		   search.setEndTime(search.getEndTime() + Config.ONE_DAY - 1);
//	   }
//	   List<UserRequest> users = DataEngine.getInstance().getDao().doSearch(search);
//	   for (UserRequest userRequest : users) {
//		   userRequest.setNewPassword(userRequest.getPassWordDefault());
//	   }
//	   return users; 
//	}
//   
//   @RequestMapping(value = "/updateUserRequest", method = RequestMethod.POST)
//	public @ResponseBody UserRequest insertUserRequest(@RequestBody UserRequest userRequest) {
//	   int status = Config.FAILURE_STATUS;
//	   if(userRequest != null){
//		   userRequest.setLastUpdate(new Date().getTime());
//		   status = DataEngine.getInstance().getDao().updateUserRequest(userRequest);
//		   userRequest.setNewPassword(userRequest.getPassWordDefault());
//		   userRequest.setStatus(status);
//		   return userRequest;
//	   }
//	   return null;
//	}
// 
//   @RequestMapping(value= {"getUserRequests"}, method = RequestMethod.POST)
//  	public @ResponseBody CursorResults<UserRequest> getDocuments(@RequestBody UserRequest userRequest) {
//  	   int offset = userRequest.getOffset();
//  		List<UserRequest> userRequests = DataEngine.getInstance().getDao().getUserRequests(offset, userRequest.getStatus());
//  		for (UserRequest request : userRequests) {
//  			request.setNewPassword(request.getPassWordDefault());
//		}
////  		log.warning("======userRequests====="+userRequests.size());
//  		long totalUserRequest = DataEngine.getInstance().getDao().getTotalUserRequest(userRequest.getStatus());
////  		log.warning("==========="+totalUserRequest );
//  		return new CursorResults<UserRequest>(userRequests, "", (int) totalUserRequest);
//  	}
//   
//   @RequestMapping(value="/login", method = RequestMethod.POST)
// 	public @ResponseBody UserInfo signIn(@RequestBody UserInfo info) {
// 	   UserInfo userInfo = DataEngine.getInstance().getDao().signIn(info);
// 	 	return userInfo;
// 	}
//   
//   @RequestMapping(value="/changePassword", method = RequestMethod.POST)
//	public @ResponseBody UserInfo changePassword(@RequestBody UserInfo info) {
//	   UserInfo userInfo = DataEngine.getInstance().getDao().changePassword(info);
//	 	return userInfo;
//	}
//
//   @RequestMapping(value="/sendMail", method = RequestMethod.POST)
//  	public @ResponseBody UserRequest saveDocument(@RequestBody UserRequest userRequest) {
//	   if(userRequest.getNewPassword().isEmpty()){
//		   userRequest.setNewPassword(userRequest.getPassWordDefault());
//	   }
//	   DataEngine.getInstance().getDao().sendMail(SeverUtil.contentEmail(userRequest), userRequest.getEmailRecent());
//	   userRequest.setLastUpdate(new Date().getTime());
//	   userRequest.setStatus(Config.USER_REQUEST_SENT);
//	   DataEngine.getInstance().getDao().updateUserRequest(userRequest);
//  	 	return userRequest;
//  	}
   
   private boolean checkLocal(HttpServletRequest req){
	  return req.getLocalName().contains("localhost");
   }
   
}

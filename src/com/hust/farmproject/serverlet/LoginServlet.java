package com.hust.farmproject.serverlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hust.farmproject.model.UserInfo;
import com.hust.farmproject.server.DataEngine;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends BasicServerlet {
	private static final long serialVersionUID = 1L;
	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String err = "";
		if (username.equals("") || password.equals("")) {
			err += "Phải nhập đầy đủ thông tin!";
		} else {
			UserInfo userInfo = DataEngine.getInstance().getDao().login(username, password);
			if(userInfo == null){
				err += "Tên đăng nhập hoặc mật khẩu không chính xác!";
			}
		}

		if (err.length() > 0) {
			request.setAttribute("err", err);
		}
		String url = "";
		System.out.println("url: "+ url +" err: "+ err);
		try {
			if (err.length() == 0) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				Cookie loginCookie = new Cookie("username",username);
	            //setting cookie to expiry in 30 mins
	            loginCookie.setMaxAge(30*60);
	            response.addCookie(loginCookie);
	            response.sendRedirect("index.jsp");
				url = "/home";
			} else {
				url = "/login";
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher(url);
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/login");
		}
	}

}

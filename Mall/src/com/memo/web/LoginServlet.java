package com.memo.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.memo.entity.User;
import com.memo.service.IncomeService;
import com.memo.service.UserService;

/**
 * Servlet implementation class ListTribeServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		System.out.println(phone+"-----------"+password);
		User user = new User();
		user.setPhone(phone);
		user.setPassword(password);
		UserService service = new UserService();
		if (service.getUserByPhone(user)!= null) {
			Gson json = new Gson();
			response.getWriter().write(
					json.toJson(service.getUserByPhone(user)));
		} else {
			response.getWriter().write("false");
		}
	}

}

package com.memo.web;


import java.io.IOException;
import java.lang.reflect.Type;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.memo.entity.Expend;
import com.memo.entity.User;
import com.memo.service.ExpendService;
import com.memo.service.IncomeService;
import com.memo.service.UserService;
/**
 * Servlet implementation class AddTribeServlet
 */
public class AddExpendServlet extends HttpServlet {
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
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String expendinfo = request.getParameter("expendinfo");
		
		Gson gson = new Gson();
		Type type = new TypeToken<Expend>(){}.getType();
		Expend expend = gson.fromJson(expendinfo, type);
		response.getWriter().write(new ExpendService().saveExpend(expend) + "");

	}

}

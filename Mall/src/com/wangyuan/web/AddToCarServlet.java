package com.wangyuan.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wangyuan.dao.UserDao;
import com.wangyuan.entity.Car;
import com.wangyuan.entity.ServerEntity;
import com.wangyuan.entity.User;
import com.wangyuan.service.CarService;
import com.wangyuan.service.ShopService;

/**
 * Servlet implementation class ListTribeServlet
 */
public class AddToCarServlet extends HttpServlet {
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

		int uid = Integer.parseInt(request.getParameter("uid"));
		int sid = Integer.parseInt(request.getParameter("sid"));

		CarService service = new CarService();
		boolean flag = service.save(uid, sid);
		if (flag) {
			response.getWriter().write("true");
		} else {
			response.getWriter().write("false");
		}

	}

}

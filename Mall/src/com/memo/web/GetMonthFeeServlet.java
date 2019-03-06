package com.memo.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.memo.entity.Revenue;
import com.memo.service.RevenueService;

/**
 * Servlet implementation class GetMonthFeeServlet
 */
public class GetMonthFeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetMonthFeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		int uid = Integer.parseInt(request.getParameter("uid"));
		Gson gson = new Gson();
		List<Revenue> list = new RevenueService().getMonthRevenue(uid);
		int out = 0;
		int in = 0;
		for (int i = 0; i < list.size(); i++) {
			Revenue r = list.get(i);
			if (r.getType().getType() == 0) {
				out = out - Integer.parseInt(r.getAccount());
			} else if (r.getType().getType() == 1) {
				in = in + Integer.parseInt(r.getAccount());
			}
		}
		response.getWriter().write(out + "," + in);
	}

}

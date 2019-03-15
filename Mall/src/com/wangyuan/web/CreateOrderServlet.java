package com.wangyuan.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wangyuan.service.OrderService;



/**
 * Servlet implementation class AddActivityServlet
 */
public class CreateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateOrderServlet() {
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
		response.setContentType("text/html;charset=utf-8");

		int uid = Integer.parseInt(request.getParameter("uid"));
		int sid = Integer.parseInt(request.getParameter("sid"));
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		OrderService service = new OrderService();
		boolean issuccess = service.save(uid, sid, address, phone);
		if(issuccess){
			response.getWriter().write("true");
		}else{
			response.getWriter().write("false");
		}
	}

}

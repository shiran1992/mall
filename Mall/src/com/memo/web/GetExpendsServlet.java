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
import com.memo.entity.Memo;
import com.memo.service.ExpendService;
import com.memo.service.MemoService;
import com.memo.service.UserService;

/**
 * Servlet implementation class OneOfSchoolInfoServlet
 */
public class GetExpendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetExpendsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		int userId = Integer.parseInt(request.getParameter("uid"));
		ExpendService service = new ExpendService();
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(service.getExpendsByUid(userId)));
//		https://pic2.zhimg.com/d6417bf9cbbf4d9c19fb3e7be1b9295a_1200x500.jpg
	}

}

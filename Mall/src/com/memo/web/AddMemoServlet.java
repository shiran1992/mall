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
public class AddMemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMemoServlet() {
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
		String memoinfo = request.getParameter("memoinfo");
		
		Gson gson = new Gson();
		Type type = new TypeToken<Memo>(){}.getType();
		Memo memo = gson.fromJson(memoinfo, type);
		response.getWriter().write(new MemoService().saveMemo(memo) + "");
		
	}

}

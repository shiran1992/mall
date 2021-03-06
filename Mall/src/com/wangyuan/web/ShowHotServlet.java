package com.wangyuan.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangyuan.entity.Hot;
import com.wangyuan.entity.Recom;
import com.wangyuan.service.HotService;
import com.wangyuan.service.RecomService;

/**
 * Servlet implementation class ShowHotServlet
 */
public class ShowHotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowHotServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		
		String[] ids =request.getParameterValues("chkCleaners");
		HotService service = new HotService();
		Hot hot = service.getHotByID(Integer.parseInt(ids[0]));
		request.setAttribute("hotinfo", hot);
		request.getRequestDispatcher("/change_hot.jsp").
		forward(request, response);
	}

}

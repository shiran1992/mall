package com.wangyuan.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wangyuan.service.CleanerService;

/**
 * Servlet implementation class DeleteApplyServlet
 */
public class DeleteCleanerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCleanerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String[] ids =request.getParameterValues("chkCleaners");
		CleanerService service = new CleanerService();
		if(service.deleteCleanerByCid(Integer.parseInt(ids[0]))){
			request.setAttribute("cleaners", new CleanerService().getCleaner());
			request.getRequestDispatcher("/list_cleaners.jsp").
			forward(request, response);
		}
	}
}

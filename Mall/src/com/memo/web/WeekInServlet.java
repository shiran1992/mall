package com.memo.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.memo.entity.Revenue;
import com.memo.service.RevenueService;

/**
 * Servlet implementation class WeekInServlet
 */
public class WeekInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeekInServlet() {
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
		int uid = Integer.parseInt(request.getParameter("uid"));
		List list = new RevenueService().getWeekInRevByUid(uid);
		int[] weekFee = {0,0,0,0,0,0,0};
		for(int i = 0; i<list.size(); i++){
			Revenue r = (Revenue) list.get(i);
			Date d = new Date(Long.parseLong(r.getDateTime()));
			if(new Date().getTime() - d.getTime() < 1000*60*60*24*7 && new Date().getDay() >= d.getDay()){
				int index = d.getDay();
				weekFee[index] = weekFee[index] + Integer.parseInt(r.getAccount());
			}
		}
		response.getWriter().write(weekFee[0]+","+weekFee[1]+","+weekFee[2]+","+
		weekFee[3]+","+weekFee[4]+","+weekFee[5]+","+weekFee[6]);
	}

}

package com.wangyuan.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangyuan.entity.Shop;
import com.wangyuan.service.ShopService;

/**
 * Servlet implementation class ApplyTribeServlet
 */
public class ShowShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowShopServlet() {
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
		
		String[] ids =request.getParameterValues("chkServers");
		ShopService service = new ShopService();
		Shop shop = service.getShopBySid(Integer.parseInt(ids[0]));
		request.setAttribute("shopinfo", shop);
		request.getRequestDispatcher("/change_shop.jsp").
		forward(request, response);
			
	}

}

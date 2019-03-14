package com.wangyuan.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.wangyuan.entity.Shop;
import com.wangyuan.service.ShopService;

/**
 * Servlet implementation class Activity_ApplicationServlet
 */
public class ChangeShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeShopServlet() {
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

		String p = this.getServletContext().getRealPath("mall");
		System.out.println(p);
		// 用smartupload获得上传文件

		SmartUpload smartUpload = new SmartUpload();
		// 初始化
		smartUpload.initialize(getServletConfig(), request, response);
		try {

			smartUpload.upload();
			// 放图片的文件夹
			String realPath = this.getServletContext()
					.getRealPath("mall");
			System.out.println(realPath);
			File dir = new File(realPath);

			if (!dir.exists()) {
				// 创建文件夹
				dir.mkdir();
				System.out.println("创建新文件夹");
			}
			com.jspsmart.upload.File poster = smartUpload.getFiles().getFile(0);
			if (!poster.isMissing()) {
				String path = request.getServletContext().getRealPath("/");
				// poster.getFileName() 原文件名
				File file = new File(getServletContext().getRealPath(
						"mall"), poster.getFileName());
				String saveFileName = file.getAbsolutePath();
				// 文件保存路径
				poster.saveAs(saveFileName);
				poster.saveAs(path + "mall/" + poster.getFileName());
			}			// 将头像信息保存到数据库
			String sid = smartUpload.getRequest().getParameter("sid");
			String title = smartUpload.getRequest().getParameter("title");
			String intro = smartUpload.getRequest().getParameter("intro");
			String price = smartUpload.getRequest().getParameter("price");
			String num = smartUpload.getRequest().getParameter("num");

			Shop shop = new Shop();
			shop.setSid(Integer.parseInt(sid));
			shop.setTitle(title);
			shop.setPrice(price);
			shop.setNum(Integer.parseInt(num));
			shop.setHead("mall/" + "shop"+poster.getFileName());
			shop.setIntro(intro);

			ShopService service = new ShopService();
			if (service.update(shop)) {
				request.setAttribute("shops",
						new ShopService().getShopsByPage());
				request.getRequestDispatcher("/list_shops.jsp").forward(
						request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

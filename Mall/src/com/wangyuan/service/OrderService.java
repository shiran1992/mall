package com.wangyuan.service;

import java.util.List;

import com.wangyuan.dao.OrderDao;
import com.wangyuan.entity.Order;

public class OrderService {

	OrderDao dao = new OrderDao();

	// 创建订单
	public boolean save(int uid, int sid, String allprice, String server_time) {
		return dao.save(uid, sid, allprice, server_time);
	}

	// 我的订单
	public List<Order> getPageOrders(int uid, int page) {
		return dao.getPageOrders(uid, page);
	}

	// 获取订单集合
	public List<Order> getOrdersByPage() {
		return dao.getOrdersByPage();
	}

	// 通过oid
	public Order getOrderByOid(int oid) {
		return dao.getOrderByOid(oid);
	}

	// 删除订单
	public Boolean deleteOrderByOid(int oid) {
		return dao.deleteOrderByOid(oid);
	}

	// 修改订单信息
	public boolean update(Order order) {
		return dao.update(order);
	}
}

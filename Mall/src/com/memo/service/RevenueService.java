package com.memo.service;

import java.util.List;

import com.memo.dao.RevenueDao;
import com.memo.entity.Revenue;

public class RevenueService {

	RevenueDao dao = new RevenueDao();

	// 保存信息
	public boolean saveInfo(Revenue r) {
		return dao.saveInfo(r);
	}

	// 获取今日詹丹
	public List<Revenue> getRevenueToday(int uid) {
		return dao.getRevenueToday(uid);
	}

	// 获取本月费用
	public List<Revenue> getMonthRevenue(int uid) {
		return dao.getMonthRevenue(uid);
	}

	// 获取账单
	public List<Revenue> getAllRevByUid(int uid) {
		return dao.getAllRevByUid(uid);
	}

	// 本周消费
	public List<Revenue> getWeekRevByUid(int uid) {
		return dao.getWeekRevByUid(uid);
	}

	// 获取本月费用
	public List<Revenue> getWeekInRevByUid(int uid) {
		return dao.getWeekInRevByUid(uid);
	}

}

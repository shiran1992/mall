package com.memo.service;

import java.util.List;

import com.memo.dao.ExpendDao;
import com.memo.dao.IncomeDao;
import com.memo.entity.Expend;
import com.memo.entity.Income;

public class ExpendService {

	ExpendDao dao = new ExpendDao();

	// 通过uid获取收入信息
	public List<Expend> getExpendsByUid(int uid) {
		return dao.getExpendsByUid(uid);
	}

	// 获取所有的支出列表
	public List<Expend> getAllExpends() {
		return dao.getAllExpends();
	}

	// 保存收入信息
	public boolean saveExpend(Expend expend) {
		return dao.saveExpend(expend);
	}
}

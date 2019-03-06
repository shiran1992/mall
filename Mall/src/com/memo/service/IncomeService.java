package com.memo.service;

import java.util.List;

import com.memo.dao.IncomeDao;
import com.memo.entity.Income;

public class IncomeService {

	IncomeDao dao = new IncomeDao();

	// 通过uid获取收入信息
	public List<Income> getIncomesByUid(int uid) {
		return dao.getIncomesByUid(uid);
	}
	
	//查询所有收入信息
	public List<Income> getAllIncomes() {
		return dao.getAllIncomes();
	}

	// 保存收入信息
	public boolean saveIncome(Income income) {
		return dao.saveIncome(income);
	}
}

package com.memo.service;

import java.util.List;

import com.memo.dao.ExpendDao;
import com.memo.dao.ExploreDao;
import com.memo.dao.IncomeDao;
import com.memo.entity.Expend;
import com.memo.entity.Explore;
import com.memo.entity.Income;

public class ExploreService {

	ExploreDao dao = new ExploreDao();

	// 获取所有的列表
	public List<Explore> getAllExplores() {
		return dao.getAllExplores();
	}
}

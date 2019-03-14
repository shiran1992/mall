package com.wangyuan.service;

import java.util.ArrayList;
import java.util.List;

import com.wangyuan.dao.RecomDao;
import com.wangyuan.entity.Recom;

public class RecomService {

	RecomDao dao = new RecomDao();

	// 分页获取活动列表
	public List<Recom> getRecomByPage(int page) {
		return dao.getRecomByPage(page);
	}

	public List<Recom> getRecoms() {
		return dao.getRecoms();
	}

	// 通过id来搜索cleaner
	public Recom getRecomByID(int cid) {
		return dao.getRecomByID(cid);
	}

	// 创建服务
	public boolean save(Recom recom) {
		return dao.save(recom);
	}

	// 删除员工
	public Boolean deleteRecomByRid(int rid) {
		return dao.deleteRecomByRid(rid);
	}

	// 修改员工信息
	public boolean update(Recom recom) {
		return dao.update(recom);
	}
}

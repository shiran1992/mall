package com.wangyuan.service;

import java.util.List;

import com.wangyuan.dao.HotDao;
import com.wangyuan.dao.RecomDao;
import com.wangyuan.entity.Hot;
import com.wangyuan.entity.Recom;

public class HotService {
	HotDao dao = new HotDao();

	// 分页获取活动列表
	public List<Hot> getHotByPage(int page) {
		return dao.getHotByPage(page);
	}

	public List<Hot> getHots() {
		return dao.getHots();
	}

	// 通过id来搜索cleaner
	public Hot getHotByID(int hid) {
		return dao.getHotByID(hid);
	}

	// 创建服务
	public boolean save(Hot hot) {
		return dao.save(hot);
	}

	// 删除员工
	public Boolean deleteHotByHid(int hid) {
		return dao.deleteHotByHid(hid);
	}

	// 修改员工信息
	public boolean update(Hot hot) {
		return dao.update(hot);
	}
}

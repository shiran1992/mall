package com.wangyuan.service;

import java.util.List;

import com.wangyuan.dao.ShopDao;
import com.wangyuan.entity.Shop;

public class ShopService {

	ShopDao dao = new ShopDao();

	// 通过sid
	public Shop getShopBySid(int sid) {
		return dao.getShopBySid(sid);
	}

	// 获取所有的server
	public List<Shop> getShops() {
		return dao.getShops();
	}

	// 创建服务
	public boolean save(Shop shop) {
		return dao.save(shop);
	}

	// 删除服务
	public Boolean deleteShopBySid(int sid) {
		return dao.deleteShopBySid(sid);
	}

	// 修改服务信息
	public boolean update(Shop server) {
		return dao.update(server);
	}
}

package com.example.demo.service;

import com.example.demo.entity.ShopList;

public interface ShopListService {

	Iterable<ShopList> selectAll();

	Iterable<ShopList> getOpenShops(String selectedDay);

	//	// 新しいメソッドを追加
	//    String getShopHolidays(String shopName);
}

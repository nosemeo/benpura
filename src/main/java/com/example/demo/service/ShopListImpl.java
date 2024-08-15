package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ShopList;
import com.example.demo.repository.ShopListRepository;

// 使う方だけ記述
@Service
public class ShopListImpl implements ShopListService {

	@Autowired
	ShopListRepository repository;
	//	@Autowired
	//	ShopListService shopListService;

	@Override
	public Iterable<ShopList> selectAll() {
		return repository.findAll();
	}

	// 曜日確認用に新しいメソッドを追加
    @Override
    public String getShopHolidays(String shopName) {
        ShopList shop = repository.findByShopName(shopName);
        return shop != null ? shop.getHoliday() : null;
    }

}

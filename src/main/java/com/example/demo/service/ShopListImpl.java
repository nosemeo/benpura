package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

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

//	// 曜日確認用に新しいメソッドを追加
	@Override
    public Iterable<ShopList> getOpenShops(String selectedDay){
    	Iterable<ShopList> allShops = selectAll();
    	List<ShopList> openShops = new ArrayList<>();
    	
    	for(ShopList shop : allShops) {
    		String holidays = shop.getHoliday();	// 店舗の休業日
    		String[] holidayArray = holidays.split("・");	// ・で区切って配列に分割
    		
    		boolean isOpen = true;
    		for(String holiday : holidayArray) {
    			if(holiday.equals(selectedDay)) {
    				isOpen = false;
    				break;
    			}
    		}
    		if(isOpen) {
    			openShops.add(shop);	// 休業日に選ばれた曜日が含まれていない場合のみリストに追加
    		}
    	}
    	return openShops;
    }
//    public String getShopHolidays(String shopName) {
//        ShopList shop = repository.findByShopName(shopName);
//        return shop != null ? shop.getHoliday() : null;
//    }

}

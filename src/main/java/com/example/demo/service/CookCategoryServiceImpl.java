package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CookCategory;
import com.example.demo.repository.CookCategoryRepository;
@Service
public class CookCategoryServiceImpl implements CookCategoryService{
	
	@Autowired
	private CookCategoryRepository cookCategoryRepository;
	
	@Override
	public List<CookCategory> getAllCookCategory() {
		// 空のリストを作成
	    List<CookCategory> cookCategories = new ArrayList<>();
	    
	    // findAll() メソッドで取得した Iterable をリストに追加
	    for (CookCategory category : cookCategoryRepository.findAll()) {
	        cookCategories.add(category);
	    }
	    // 変換したリストを返す
	    return cookCategories;
	}
	
}

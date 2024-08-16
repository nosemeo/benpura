package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CookCategory;
import com.example.demo.repository.CookCategoryRepository;
@Service
public class SettlementServiceImpl implements SettlementService {
	@Autowired
	CookCategoryRepository repository;
	
	@Override
	public Optional<CookCategory> select(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.findById(id);
	}

}

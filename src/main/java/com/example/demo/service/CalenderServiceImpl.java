package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Calender;
import com.example.demo.repository.CalenderRepository;

@Service
@Transactional
public class CalenderServiceImpl implements CalenderService {
	
	@Autowired
	CalenderRepository repository;
	
	//注文履歴を全件取得
	@Override
	public Iterable<Calender> selectAll() {
		//全てのデータをDBから取得
		return null;
	}
	
	
	
	
}
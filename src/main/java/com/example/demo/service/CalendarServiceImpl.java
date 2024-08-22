package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Calendar;
import com.example.demo.repository.CalendarRepository;

@Service
@Transactional
public class CalendarServiceImpl implements CalendarService {
	
	@Autowired
	CalendarRepository repository;
	
	//注文履歴を全件取得
	@Override
	public Iterable<Calendar> selectAll() {
		//全てのデータをDBから取得
		return repository.findAll();
	}
	
	
	
	
}

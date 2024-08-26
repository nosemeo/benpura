package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.repository.CalendarRepository;
import com.example.demo.repository.OrderRepository;
@Service
public class SettlementServiceImpl implements SettlementService {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	CalendarRepository calendarRepository;

	@Override
	public void insertOrder(Order order) {
		// 注文履歴テーブルに追加
		orderRepository.save(order);
	}

	
	
	
	
	

}

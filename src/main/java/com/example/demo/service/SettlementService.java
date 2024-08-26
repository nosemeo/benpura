package com.example.demo.service;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Order;

@Transactional
public interface SettlementService {
	void insertOrder(Order order);
}


package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.CookCategory;

public interface SettlementService {
	Optional<CookCategory> select(Integer id);
}

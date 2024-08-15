package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Order;

public interface OderRepository extends CrudRepository<Order, Integer>{

}

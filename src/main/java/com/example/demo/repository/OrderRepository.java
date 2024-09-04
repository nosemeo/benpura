package com.example.demo.repository;

import java.time.LocalDateTime;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Orders;

public interface OrderRepository extends CrudRepository<Orders, Integer>{
	@Query(value="select * orders weher mailaddress = :mailaddres and date ")
	Iterable<Orders> selectMailaddress(String mailaddress,LocalDateTime date,LocalDateTime sevenDays);

}

package com.example.demo.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Calendar;

public interface CalendarRepository extends CrudRepository<Calendar,Integer> {
	@Query(value = "select * from order weher mailaddress=:mailaddress")
	Iterable<Calendar> findById(String mailaddress);

}

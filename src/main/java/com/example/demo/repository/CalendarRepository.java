package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Calendar;

public interface CalendarRepository extends CrudRepository<Calendar,Integer> {

}

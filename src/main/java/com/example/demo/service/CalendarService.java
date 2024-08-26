package com.example.demo.service;

import com.example.demo.entity.Calendar;

public interface CalendarService {
	
	Iterable<Calendar> selectAll();
	Iterable<Calendar> selectById(String mailaddress);
	
}

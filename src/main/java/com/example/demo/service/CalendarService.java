package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Calendar;

public interface CalendarService {
	
	// 注文履歴を全件取得 (SQLクエリで注文日時を昇降順に並び替え)
	Iterable<Calendar>selectAll();
	
	// mailaddressと合致する注文履歴のみリストに追加
	List<Calendar>matchLoginidOrderlist(String mailaddress,Iterable<Calendar> list);
	
}

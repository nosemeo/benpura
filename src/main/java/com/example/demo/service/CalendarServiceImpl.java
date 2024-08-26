package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

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
	
	    
	// 注文履歴を全件取得 (SQLクエリで注文日時を昇降順に並び替え)
	@Override
	public Iterable<Calendar> selectAll() { 
		return repository.selectAll();
	}

	// mailaddressと合致する注文履歴のみリストに追加
	@Override
	public List<Calendar> matchLoginidOrderlist(String mailaddress, Iterable<Calendar> list) {
		List<Calendar> matchlist = new ArrayList<>();
		for (Calendar temp : list) {
			// ログインページから読み込んだ時
			// ユーザー名を受け取っているか確認
			if (!(mailaddress == null)) {
				if (temp.getMailaddress().equals(mailaddress)) {
					matchlist.add(temp);
				}
			}
		}
		return matchlist;
	}


	
	
	
	
}

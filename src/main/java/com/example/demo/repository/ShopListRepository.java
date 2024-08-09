package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.ShopList;

// この作業がデータベースからとってくる処理
// 1つ目の引数がentity
public interface ShopListRepository extends CrudRepository<ShopList,Integer>{
	

}

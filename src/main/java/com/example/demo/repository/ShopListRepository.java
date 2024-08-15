package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.ShopList;

// この作業がデータベースからとってくる処理
// 1つ目の引数がentity
// 二つ目は主キーの型が入る
public interface ShopListRepository extends CrudRepository<ShopList, Integer> {

//}

//public interface ShopListRepository extends JpaRepository<ShopList, Long> {

	// 店名で店舗情報を取得するメソッドを作成(曜日確認用に追記)
    ShopList findByShopName(String shopName);
}
package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="order") // 呼び出したいDBのテーブル名を指定
//
//  entityパッケージ
//  Calenderクラスの生成
//
public class Calender {
	
	@Id
	private Integer id;	
	private String date;
//　Date型にするとたくさんエラーがでる
//	今はとりあえずStringで定義
	private String name;
	private String item;
	private Integer price;
	
	
}
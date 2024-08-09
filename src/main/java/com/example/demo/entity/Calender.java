package com.example.demo.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//
//  entityパッケージ
//  Calenderクラスの生成
//
public class Calender {
	
	@Id
	private Integer orderId;	
	private String orderDateTime;
//　Date型にするとたくさんエラーがでる
//	今はとりあえずStringで定義
	private String shopName;
	private String item;
	private Integer totalValue;
	
	
	
}
package com.example.demo.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalenderEntity {
	
	@Id
	private String orderDateTime;
//　Date型にするとたくさんエラーがでる
//	今はとりあえずStringで定義
	private String shopName;
	private String name;
	private Integer totalValue;
	
	
	
}
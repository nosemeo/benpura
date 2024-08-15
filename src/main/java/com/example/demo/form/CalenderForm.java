package com.example.demo.form;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalenderForm {
	
	@Id
	private String orderdate;
//　Date型にするとたくさんエラーがでる
//	今はとりあえずStringで定義
	
//	private String dayofweek;
	
}
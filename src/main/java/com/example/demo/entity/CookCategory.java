package com.example.demo.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CookCategory {
	
	@Id
	private Integer id;
	private Integer shopId;
	private String item;
	private String introductions;
	private byte[] image;
	private String recommend;
	private String comments1;
	private String comments2;
	private String bentoType;
	private String typeComments;
	private Integer priceS;
	private Integer priceM;
	private String comments1Color;
	
}

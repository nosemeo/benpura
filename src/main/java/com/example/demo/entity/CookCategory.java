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
	private String item;
	private String priceS;
	private String priceM;
	private String introductions;
	private byte[] imagePath;
	private Integer shopnameId;
	private boolean osusume;
	
}

package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopList {
	private Integer id;
	private String shopName;
	private String shopAddress;
	private Integer shopTel;
	private String shopHour;
	private String holiday;
	private byte[] shopPicture;

}

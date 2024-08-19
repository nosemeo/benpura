package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
private String image;//画像
private String name;//名前
private String shopName;//店名
private int price;//値段
private int number;//個数
private LocalDateTime pickupTime;//日時
}

package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class CartDto {
private String image;//画像
private String name;//名前
private String shopName;//店名
private Integer price;//値段
private Integer number;//個数
private LocalDateTime pickupTime;//日時
}

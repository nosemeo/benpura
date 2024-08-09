package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class CartDto {
private String image;
private String name;
private String price;
private Integer number;
}

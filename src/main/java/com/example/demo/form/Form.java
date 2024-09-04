package com.example.demo.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//
//次のページにデータを飛ばすためのフォルダ
//
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Form {
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate orderdate;
	private String ordertime;
	private String dayofweek;
	private String mailaddress;
	
}
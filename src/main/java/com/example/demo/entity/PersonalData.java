package com.example.demo.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonalData {
	@Id
	private String username;
	private String password;
	private String famNameKanji;
	private String nameKanji;
	private String famNameFurigana;
	private String nameFurigana;
	private Boolean gender;
	private Integer year;
	private Integer month;
	private Integer day;
	private String tel;
}

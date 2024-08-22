package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RegisterForm {

	@NotBlank(message = "メールアドレスを入力してください。")
	@Email(message = "有効なメールアドレスを入力してください。")
	
	@Length(max = 50)
	private String mailAddress;

	@NotBlank(message = "パスワードを入力してください。")
	
	@Length(max = 50)
	private String password;

	@NotBlank(message = "姓を入力してください。")
	
	@Length(max = 50)
	private String famNameKanji;

	@NotBlank(message = "名を入力してください。")
	
	@Length(max = 50)
	private String nameKanji;

	@NotBlank(message = "セイを入力してください。")
	
	@Length(max = 50)
	private String famNameFurigana;

	@NotBlank(message = "メイを入力してください。")
	
	@Length(max = 50)
	private String nameFurigana;

	@NotNull(message = "性別を選択してください。")
	private Boolean gender;

	@NotNull(message = "年を入力してください。")

	private Integer year;

	@NotNull(message = "月を入力してください。")
	private Integer month;

	@NotNull(message = "日を入力してください。")
	private Integer day;

	@NotBlank(message = "電話番号を入力してください。")
	
	@Length(max = 50)
	private String tel;

}

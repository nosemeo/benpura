package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoginForm {
	
	//@NotBlank(message = "メールアドレスを入力してください。")
	//@Email(message = "有効なメールアドレスを入力してください。")
	
	@Length(max = 50)
	private String mailAddress;

	//@NotBlank(message = "パスワードを入力してください。")
	
	@Length(max = 50)
	private String password;
	

}

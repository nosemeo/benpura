package com.example.demo.service.userdetails;

import com.example.demo.entity.PersonalData;
import com.example.demo.form.RegisterForm;

public interface RegisterService {

	Iterable<PersonalData> selectAll();

	// 情報を新規登録
	void save(RegisterForm registerForm);
	
	boolean findById(String mailAddress);

}

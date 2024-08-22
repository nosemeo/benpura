package com.example.demo.service.userdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.PersonalData;
import com.example.demo.form.RegisterForm;
import com.example.demo.repository.RegisterRepository;

@Service
@Transactional

public class RegisterServiceImpl implements RegisterService {
	@Autowired
	RegisterRepository repository;

	@Override
	public Iterable<PersonalData> selectAll() {
		return repository.findAll();
	}

	@Override
	public void save(RegisterForm registerForm) {
		//情報を保存

		repository.insert(registerForm.getMailAddress(), new BCryptPasswordEncoder().encode(registerForm.getPassword()),
				registerForm.getFamNameKanji(), registerForm.getNameKanji(), registerForm.getFamNameFurigana(),
				registerForm.getFamNameFurigana(),
				registerForm.getGender(), registerForm.getYear(), registerForm.getMonth(), registerForm.getDay(),
				registerForm.getTel());
	}

	@Override
	public boolean findById(String mailAddress) {
		
		return repository.findByUsername(mailAddress) != null;
	}

}

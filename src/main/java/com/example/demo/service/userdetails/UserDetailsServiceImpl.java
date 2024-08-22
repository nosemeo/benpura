package com.example.demo.service.userdetails;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PersonalData;
import com.example.demo.repository.LoginUserRepository;

@Service

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	LoginUserRepository loginUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<PersonalData> loginUserOpt = loginUserRepository.findById(username);
		
		if(loginUserOpt.isEmpty()) {
			throw new UsernameNotFoundException("ユーザーが存在しません");
		}else {
			
			return new UserDetailsImpl(loginUserOpt.get());
		}

	}

}

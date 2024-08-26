package com.example.demo.service.userdetails;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PersonalData;
import com.example.demo.repository.LoginUserRepository;

import jakarta.servlet.http.HttpSession;

@Service

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	LoginUserRepository loginUserRepository;

	// 若松：セッション準備 HttpSession型のフィールドを定義する
	private HttpSession session;

	// 若松：クラスの自動生成
	@Autowired
	public void SessionController(HttpSession session) {
		// フィールドに代入する
		this.session = session;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<PersonalData> loginUserOpt = loginUserRepository.findById(username);

		// 若松 セッションにユーザー名/メールアドレスを保存
		this.session.setAttribute("mailaddress",username);
	

		if (loginUserOpt.isEmpty()) {
			throw new UsernameNotFoundException("ユーザーが存在しません");
		} else {

			return new UserDetailsImpl(loginUserOpt.get());
		}

	}

}

package com.example.demo.service.userdetails;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.PersonalData;

public class UserDetailsImpl implements UserDetails {
	private final PersonalData loginUser;

	public UserDetailsImpl(PersonalData loginUser) {
		this.loginUser = loginUser;

	}

	@Override
	public String getPassword() {
		// ハッシュ化済みのパスワードを返す
		return loginUser.getPassword();
	}

	@Override
	public String getUsername() {
		// ログインで利用するユーザー名を返す
		return loginUser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// ユーザーが期限切れでなければtrueを返す
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// ユーザーがロックされていなければtrueを返す
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// ユーザーのパスワードの期限が切れていなければtrueを返す
		return true;
	}

	@Override
	public boolean isEnabled() {
		// ユーザーが有効であればtrueを返す
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}

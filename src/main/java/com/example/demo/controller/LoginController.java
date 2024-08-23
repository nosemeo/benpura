package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.form.LoginForm;

import jakarta.servlet.http.HttpSession;

@Controller

public class LoginController {
	@Autowired
	private SmartValidator validator;

	// 若松：セッション準備 HttpSession型のフィールドを定義する
	private HttpSession session;

	// 若松：クラスの自動生成
	@Autowired
	public void SessionController(HttpSession session) {
		// フィールドに代入する
		this.session = session;
	}
	
	
	// SecurityConfigのloginPageで指定したURL
	@GetMapping("/login") //local host url
	public String loginForm(LoginForm loginForm) {
		// ログイン画面を表示
		
		System.out.println("ログインします。");
		
		 String mailaddress = loginForm.getMailAddress();
		 
		// 若松：セッションの保存
		System.out.println("mailaddress login 1：  "+mailaddress);
		this.session.setAttribute("mailaddress",mailaddress);
		
		return "login";//html file
	}

	// SecurityConfigのfailureUrlで指定したURLと?のうしろのパラメータ
	@GetMapping(value = "/login", params = "failure")
	public String loginFail(LoginForm loginForm, BindingResult result, Model model, HttpSession session) {
		//空白や間違ってる時のメッセージ↓↓↓
		model.addAttribute("failureMessage", "ID又はPASSWORDが失敗しました");

		String userName = (String) session.getAttribute("userName");
		String userPass = (String) session.getAttribute("userPass");

		loginForm.setMailAddress(userName);
		loginForm.setPassword(userPass);

		validator.validate(loginForm, result);
		
		// 若松：セッションの保存
		System.out.println("mailaddress login 2：  "+loginForm.getMailAddress());
		this.session.setAttribute("mailaddress",loginForm.getMailAddress());
	
		// ログイン画面を表示
		return "login";
	}

	//	// SecurityConfigのdefaultSuccessUrlで指定したURL
	//	@GetMapping("calendar") //local host url
	//	public String loginSuccess() {
	//		// ログインに成功したら表示するURL
	//		return "calendar";//html file
	//	}

}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.RegisterForm;
import com.example.demo.service.userdetails.RegisterService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class RegisterController {

	@Autowired
	RegisterService service;

	// 若松：セッション準備 HttpSession型のフィールドを定義する
	private HttpSession session;

	// 若松：クラスの自動生成
	@Autowired
	public void SessionController(HttpSession session) {
		// フィールドに代入する
		this.session = session;
	}

	@GetMapping("/register")
	public String register(RegisterForm registerForm) {
		
		System.out.println("mailaddress regi 1：  "+registerForm.getMailAddress());
		this.session.setAttribute("mailaddress",registerForm.getMailAddress());
		
		return "register";
	}

	@PostMapping("/register")
	public String showRegisterForm(RegisterForm registerForm) {
		
		System.out.println("mailaddress regi 1：  "+registerForm.getMailAddress());
		this.session.setAttribute("mailaddress",registerForm.getMailAddress());
		
		return "register";
	}

	@PostMapping("confirm") //el hikisu es el url (el url NO necesariamente tiene el mismo nombre del archivo html) 
	public String confirm(@Validated RegisterForm registerForm, BindingResult bindingResult, Model model) {
		if (service.findById(registerForm.getMailAddress())) {
			bindingResult.rejectValue("mailAddress", "error.mailAddress", "このメールアドレスは既に登録されています。");
		}

		if (bindingResult.hasErrors()) {
			return "register";
		}

		String password = registerForm.getPassword();
		String passwordMasked = getMaskedPassword(password);
		model.addAttribute("passwordMasked", passwordMasked);
		
		// 若松：セッションの保存
		System.out.println("mailaddress regi 1：  "+registerForm.getMailAddress());
		this.session.setAttribute("mailaddress",registerForm.getMailAddress());
		
		return "confirm";//html file
	}

	@PostMapping("success") //el hikisu es el url (el url NO necesariamente tiene el mismo nombre del archivo html)
	public String register2(RegisterForm registerForm, HttpServletRequest request) {
		//新規登録ため
		service.save(registerForm);

		// ログインしている状態であれば、一度ログアウトさせる
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		if (authentication instanceof AnonymousAuthenticationToken == false) {
			SecurityContextHolder.clearContext();
		}

		try {
			request.login(registerForm.getMailAddress(), registerForm.getPassword());
		} catch (ServletException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		// 若松：セッションの保存
		System.out.println("mailaddress regi 2：  "+registerForm.getMailAddress());
		this.session.setAttribute("mailaddress",registerForm.getMailAddress());
		
		return "redirect:/calendar";//el nombre del archivo html
	}

	public String getMaskedPassword(String password) {
		if (password == null) {
			return "";
		}
		return "*".repeat(password.length());
	}

}

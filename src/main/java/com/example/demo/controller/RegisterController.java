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

@Controller
public class RegisterController {

	@Autowired
	RegisterService service;

	@GetMapping("/register")
	public String register(RegisterForm registerForm) {
		return "register";
	}

	@PostMapping("/register")
	public String showRegisterForm(RegisterForm registerForm) {
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

		return "redirect:/calendar";//el nombre del archivo html
	}

	public String getMaskedPassword(String password) {
		if (password == null) {
			return "";
		}
		return "*".repeat(password.length());
	}

}

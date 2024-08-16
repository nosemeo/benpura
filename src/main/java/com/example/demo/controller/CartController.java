package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.entity.CookCategory;
import com.example.demo.service.SettlementServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("")

public class CartController {
	private HttpSession session;
	@Autowired
	SettlementServiceImpl service;

	@Autowired
	public CartController(HttpSession session) {
		// フィールドに代入する
		this.session = session;
	}

	@GetMapping("/cart")
	public String cartShow(Model model) {
		Optional<CookCategory> menu = service.select(1);
		model.addAttribute("menu", menu);
		return "settlement/cart";
	}
//	@GetMapping("/cart")
//	public String cartShow(CartDto dto,Model model) {
//		List<CartDto> dtoList = (List<CartDto>) this.session.getAttribute("dtoList");
//		if(dtoList.isEmpty()) {
//			dtoList = new ArrayList<>();
//		}
//		dtoList.add(dto);
//		this.session.setAttribute("dtoList", dtoList);
//		
//		model.addAttribute("dtoList",dtoList);
//		
//		return "settlement/cart";
//	}
	@PostMapping("/settlement")
	public String showSettlement() {
		
		return "settlement/settlement";
	}
}

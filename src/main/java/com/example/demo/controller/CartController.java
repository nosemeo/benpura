package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("")

public class CartController {
	private HttpSession session;

	@Autowired
	public CartController(HttpSession session) {
		// フィールドに代入する
		this.session = session;
	}

	@GetMapping("/cart")
	public String cartShow() {
		
		
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
	@GetMapping("/settlement")
	public String showSettlement() {
		return "settlement/settlement";
	}
}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopListController {
	
//	「http://localhost:8080/shopList」
	@GetMapping("/shopList")
	public String shopListShow() {
		return "shopList";
	}
	
	@GetMapping("/shopInformation")
	public String shopInformationShow() {
		return "shopInformation";
	}

}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("")

public class CartController {
@GetMapping("/cart")
public String cartShow() {
	return "settlement/cart";
}
}

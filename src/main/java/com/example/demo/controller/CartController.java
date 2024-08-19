package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.dto.CartDto;
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


	@PostMapping("/cart")
	public String cartShow(@ModelAttribute CartDto dto,Model model) {
		List<CartDto> dtoList = (List<CartDto>) this.session.getAttribute("dtoList");
		if(dtoList == null) {
			dtoList = new ArrayList<>();
		}
		dtoList.add(dto);
		this.session.setAttribute("dtoList", dtoList);
			
		
		model.addAttribute("dtoList",dtoList);
		return "settlement/cart2";
	}
	@GetMapping("/settlement")
	public String showSettlement(@ModelAttribute CartDto dto,Model model) {
		
		
			CartDto dto1 = new CartDto();
			dto1.setName("弁当");
			dto1.setShopName("Hana");
			dto1.setPrice(1000);
			dto1.setImage(null);
			dto1.setNumber(1);
			dto1.setPickupTime(LocalDateTime.now());
			model.addAttribute("dto",dto1);
		
		model.addAttribute("dto1",dto);
		return "settlement/settlement";
	}
	 @PostMapping("/delete")
	 //delete用リクエスト受ける
	    public String deleteItem(@RequestParam int bn) {
	        List<CartDto> list =(List<CartDto>) this.session.getAttribute("dtoList");
	        list.remove(bn);
	        this.session.setAttribute("dtoList", list);
	        
	        return "settlement/deleteSuccess";
	    }
	
//	@GetMapping("/reservations")
//    public String getReservations(Model model) {
//        Map<LocalDate, String> reservations = new HashMap<>();
//        // ここで予約情報を取得し、Mapに追加します
//        // 例: reservations.put(LocalDate.of(2024, 8, 12), "予約あり");
//
//        LocalDate today = LocalDate.now();
//        model.addAttribute("today", today);
//        model.addAttribute("reservations", reservations);
//        return "reservations";
//    }
}

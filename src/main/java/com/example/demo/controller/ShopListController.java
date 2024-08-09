package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.ShopList;
import com.example.demo.repository.ShopListRepository;

@Controller
public class ShopListController {
	
	@Autowired
	private ShopListRepository repository;
	
//	「http://localhost:8080/shopList」
	@GetMapping("/shopList")
	public String shopListShow(Model model) {
		Iterable<ShopList> imagedata = repository.findAll(); 
		List<String> list = new ArrayList<>();
		
		for(ShopList shopList : imagedata) {
			// nullのデータがデータベースにあったらエラーでるのでif分でnull大丈夫にしたげる
			if(shopList.getShopPicture() != null) {
		String list2 = Base64.getEncoder().encodeToString(shopList.getShopPicture());
		list.add(list2);
		}}
		model.addAttribute("image",list);
		return "shopList";
	}
	
	@GetMapping("/shopInformation")
	public String shopInformationShow(Model model) {
		Iterable<ShopList> imagedata = repository.findAll(); 
		List<String> list = new ArrayList<>();
		for(ShopList shopList : imagedata) {
			if(shopList.getShopPicture() != null) {
		String list2 = Base64.getEncoder().encodeToString(shopList.getShopPicture());
		list.add(list2);
		}}
		model.addAttribute("image",list);
		
		
		return "shopInformation";
	}

}

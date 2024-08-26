package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.CookCategory;
import com.example.demo.repository.CookCategoryRepository;
import com.example.demo.service.CookCategoryService;

@Controller
@RequestMapping("cookCategory")
public class CookController {

	@Autowired
	private CookCategoryService cookCategoryService;

	@Autowired
	private CookCategoryRepository repository;

	@GetMapping
	public String showList(Model model) {
		Iterable<CookCategory> recommendList = repository.findAll();
		List<CategoryDto> list = new ArrayList<>();
		
		for (CookCategory cookCategory : recommendList) {
			String imageString = Base64.getEncoder().encodeToString(cookCategory.getImage());
			
			if (cookCategory.getShopId() == 1) {
				
			}
			
			if (cookCategory.getRecommend().equals("true")) {
				
				list.add(new CategoryDto(cookCategory.getId(), cookCategory.getShopId(),cookCategory.getItem()
						, cookCategory.getIntroductions(), imageString, cookCategory.getRecommend(),cookCategory.getComments1()
						, cookCategory.getComments2(),cookCategory.getBentoType(),cookCategory.getTypeComments(),cookCategory.getPriceS(),cookCategory.getPriceM()));
			}
			
		}
		
		List<CategoryDto> list2 = new ArrayList<>();
		
		for (CookCategory cookCategory : recommendList) {
			String imageString = Base64.getEncoder().encodeToString(cookCategory.getImage());
			
			if (cookCategory.getTypeComments() != null) {
				list2.add(new CategoryDto(cookCategory.getId(), cookCategory.getShopId(),cookCategory.getItem()
						, cookCategory.getIntroductions(), imageString, cookCategory.getRecommend(),cookCategory.getComments1()
						, cookCategory.getComments2(),cookCategory.getBentoType(),cookCategory.getTypeComments(),cookCategory.getPriceS(),cookCategory.getPriceM()));
			}
		}
		model.addAttribute("recommendList", list);
		model.addAttribute("categoryList", list2);
		return "cookCategory";
	}

	@GetMapping("/niku")
	public String niku(Model model) {
		Iterable<CookCategory> nikuList = repository.findAll();
		List<CategoryDto> list = new ArrayList<>();
		
		for (CookCategory cookCategory : nikuList) {
			
			if (cookCategory.getBentoType().equals("niku")) {
				String imageString = Base64.getEncoder().encodeToString(cookCategory.getImage());
				
				list.add(new CategoryDto(cookCategory.getId(), cookCategory.getShopId(),cookCategory.getItem()
						, cookCategory.getIntroductions(), imageString, cookCategory.getRecommend(),cookCategory.getComments1()
						, cookCategory.getComments2(),cookCategory.getBentoType(),cookCategory.getTypeComments(),cookCategory.getPriceS(),cookCategory.getPriceM()));
			}
		}
		model.addAttribute("nikuList", list);

		return "niku";
	}

	@GetMapping("/sakana")
	public String sakana(Model model) {
		Iterable<CookCategory> sakanaList = repository.findAll();
		List<CategoryDto> list = new ArrayList<>();
		
		for (CookCategory cookCategory : sakanaList) {
			
			if (cookCategory.getBentoType().equals("sakana")) {
				String imageString = Base64.getEncoder().encodeToString(cookCategory.getImage());
				
				list.add(new CategoryDto(cookCategory.getId(), cookCategory.getShopId(),cookCategory.getItem()
						, cookCategory.getIntroductions(), imageString, cookCategory.getRecommend(),cookCategory.getComments1()
						, cookCategory.getComments2(),cookCategory.getBentoType(),cookCategory.getTypeComments(),cookCategory.getPriceS(),cookCategory.getPriceM()));
			}
		}
		model.addAttribute("sakanaList", list);
		return "sakana";
	}

	@GetMapping("/donburi")
	public String donburi(Model model) {
		Iterable<CookCategory> donburiList = repository.findAll();
		List<CategoryDto> list = new ArrayList<>();
		
		for (CookCategory cookCategory : donburiList) {
			
			if (cookCategory.getBentoType().equals("donburi")) {
				String imageString = Base64.getEncoder().encodeToString(cookCategory.getImage());
				
				list.add(new CategoryDto(cookCategory.getId(), cookCategory.getShopId(),cookCategory.getItem()
						, cookCategory.getIntroductions(), imageString, cookCategory.getRecommend(),cookCategory.getComments1()
						, cookCategory.getComments2(),cookCategory.getBentoType(),cookCategory.getTypeComments(),cookCategory.getPriceS(),cookCategory.getPriceM()));
			}
		}
		model.addAttribute("donburiList", list);
		return "donburi";
	}
}
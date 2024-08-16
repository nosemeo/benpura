package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		String osusumeSPrice = null;
		String osusumeMPrice = null;
		String higawariSPrice = null;
		String higawariMPrice = null;
		String omakaseSPrice = null;
		String omakaseMPrice = null;

		Iterable<CookCategory> imageData = repository.findAll();
		List<String> list = new ArrayList<>();
		for (CookCategory cookCategory : imageData) {

			if (cookCategory.getId() == 8) {
				String list2 = Base64.getEncoder().encodeToString(cookCategory.getImagePath());
				model.addAttribute("osusume", list2);
				osusumeSPrice = cookCategory.getPriceS().toString();
				osusumeMPrice = cookCategory.getPriceM().toString();

			} else if (cookCategory.getId() == 9) {
				String list2 = Base64.getEncoder().encodeToString(cookCategory.getImagePath());
				model.addAttribute("higawari", list2);
				higawariSPrice = cookCategory.getPriceS().toString();
				higawariMPrice = cookCategory.getPriceM().toString();

			} else if (cookCategory.getId() == 4) {
				String list2 = Base64.getEncoder().encodeToString(cookCategory.getImagePath());
				model.addAttribute("omakase", list2);
				omakaseSPrice = cookCategory.getPriceS().toString();
				omakaseMPrice = cookCategory.getPriceM().toString();

			} else if (cookCategory.getId() == 7) {
				String list2 = Base64.getEncoder().encodeToString(cookCategory.getImagePath());
				model.addAttribute("nikubentou", list2);
			} else if (cookCategory.getId() == 6) {
				String list2 = Base64.getEncoder().encodeToString(cookCategory.getImagePath());
				model.addAttribute("sakanabentou", list2);
			} else if (cookCategory.getId() == 1) {
				String list2 = Base64.getEncoder().encodeToString(cookCategory.getImagePath());
				model.addAttribute("donburi", list2);
			}
		}
		model.addAttribute("imageData", list);
		model.addAttribute("osusumeSPrice", osusumeSPrice);
		model.addAttribute("osusumeMPrice", osusumeMPrice);
		model.addAttribute("higawariSPrice", higawariSPrice);
		model.addAttribute("higawariMPrice", higawariMPrice);
		model.addAttribute("omakaseSPrice", omakaseSPrice);
		model.addAttribute("omakaseMPrice", omakaseMPrice);

		return "cookCategory";
	}

	@GetMapping("/niku")
	public String niku(Model model) {
		String hamburgerSPrice = null;
		String hamburgerMPrice = null;
		String yakinikuSPrice = null;
		String yakinikuMPrice = null;
		String chickenSPrice = null;
		String chickenMPrice = null;

		Iterable<CookCategory> imageData = repository.findAll();
		List<String> list = new ArrayList<>();
		for (CookCategory cookCategory : imageData) {
			String nikubentouImage = Base64.getEncoder().encodeToString(cookCategory.getImagePath());

			if (cookCategory.getId() == 7) {
				model.addAttribute("hamburger", nikubentouImage);
				hamburgerSPrice = cookCategory.getPriceS().toString();
				hamburgerMPrice = cookCategory.getPriceM().toString();

			} else if (cookCategory.getId() == 8) {
				model.addAttribute("yakiniku", nikubentouImage);
				yakinikuSPrice = cookCategory.getPriceS().toString();
				yakinikuMPrice = cookCategory.getPriceM().toString();

			} else if (cookCategory.getId() == 9) {
				model.addAttribute("chicken", nikubentouImage);
				chickenSPrice = cookCategory.getPriceS().toString();
				chickenMPrice = cookCategory.getPriceM().toString();
			}
		}
		model.addAttribute("imageData", list);
		model.addAttribute("hamburgerSPrice", hamburgerSPrice);
		model.addAttribute("hamburgerMPrice", hamburgerMPrice);
		model.addAttribute("yakinikuSPrice", yakinikuSPrice);
		model.addAttribute("yakinikuMPrice", yakinikuMPrice);
		model.addAttribute("chickenSPrice", chickenSPrice);
		model.addAttribute("chickenMPrice", chickenMPrice);

		return "niku";
	}

	@GetMapping("/sakana")
	public String sakana(Model model) {
		String omakaseSPrice = null;
		String omakaseMPrice = null;
		String sabaSPrice = null;
		String sabaMPrice = null;
		String syakeSPrice = null;
		String syakeMPrice = null;

		Iterable<CookCategory> imageData = repository.findAll();

		List<String> list = new ArrayList<>();
		for (CookCategory cookCategory : imageData) {
			String sakanabentouImage = Base64.getEncoder().encodeToString(cookCategory.getImagePath());

			if (cookCategory.getId() == 4) {
				model.addAttribute("omakase", sakanabentouImage);
				omakaseSPrice = cookCategory.getPriceS().toString();
				omakaseMPrice = cookCategory.getPriceM().toString();

			} else if (cookCategory.getId() == 5) {
				model.addAttribute("syake", sakanabentouImage);
				syakeSPrice = cookCategory.getPriceS().toString();
				syakeMPrice = cookCategory.getPriceM().toString();

			} else if (cookCategory.getId() == 6) {
				model.addAttribute("saba", sakanabentouImage);
				sabaSPrice = cookCategory.getPriceS().toString();
				sabaMPrice = cookCategory.getPriceM().toString();
			}
		}

		model.addAttribute("imageData", list);
		model.addAttribute("omakaseSPrice", omakaseSPrice);
		model.addAttribute("omakaseMPrice", omakaseMPrice);
		model.addAttribute("syakeSPrice", syakeSPrice);
		model.addAttribute("syakeMPrice", syakeMPrice);
		model.addAttribute("sabaSPrice", sabaSPrice);
		model.addAttribute("sabaMPrice", sabaMPrice);

		return "sakana";
	}

	@GetMapping("/donburi")
	public String donburi(Model model) {
		String katsudonSPrice = null;
		String katsudonMPrice = null;
		String yakinikubSPrice = null;
		String yakinikubMPrice = null;
		String oyakodonSPrice = null;
		String oyakodonMPrice = null;

		Iterable<CookCategory> imageData = repository.findAll();

		List<String> list = new ArrayList<>();
		for (CookCategory cookCategory : imageData) {
			String donburiImage = Base64.getEncoder().encodeToString(cookCategory.getImagePath());

			if (cookCategory.getId() == 1) {
				model.addAttribute("katsudon", donburiImage);
				katsudonSPrice = cookCategory.getPriceS().toString();
				katsudonMPrice = cookCategory.getPriceM().toString();

			} else if (cookCategory.getId() == 2) {
				model.addAttribute("yakinikub", donburiImage);
				yakinikubSPrice = cookCategory.getPriceS().toString();
				yakinikubMPrice = cookCategory.getPriceM().toString();
				
			} else if (cookCategory.getId() == 3) {
				model.addAttribute("oyakodon", donburiImage);
				oyakodonSPrice = cookCategory.getPriceS().toString();
				oyakodonMPrice = cookCategory.getPriceM().toString();
			}
		}
		model.addAttribute("imageData", list);
		model.addAttribute("katsudonSPrice", katsudonSPrice);
		model.addAttribute("katsudonMPrice", katsudonMPrice);
		model.addAttribute("yakinikubSPrice", yakinikubSPrice);
		model.addAttribute("yakinikubMPrice", yakinikubMPrice);
		model.addAttribute("oyakodonSPrice", oyakodonSPrice);
		model.addAttribute("oyakodonMPrice", oyakodonMPrice);
		
		return "donburi";
	}
}

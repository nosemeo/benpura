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
		String osusumeIntroductions = "";
		String higawariIntroductions = "";
		String omakaseIntroductions = "";
		String osusumeName = "";
		String higawariName = "";
		String omakaseName = "";
		String shopnameId = null;
		

		Iterable<CookCategory> imageData = repository.findAll();
		List<String> list = new ArrayList<>();
		for (CookCategory cookCategory : imageData) {

			if (cookCategory.getId() == 8) {
				String list2 = Base64.getEncoder().encodeToString(cookCategory.getImagePath());
				model.addAttribute("osusume", list2);
				osusumeSPrice = cookCategory.getPriceS().toString();
				osusumeMPrice = cookCategory.getPriceM().toString();
				osusumeIntroductions = cookCategory.getIntroductions().toString();
				osusumeName = cookCategory.getItem();

			} else if (cookCategory.getId() == 9) {
				String list2 = Base64.getEncoder().encodeToString(cookCategory.getImagePath());
				model.addAttribute("higawari", list2);
				higawariSPrice = cookCategory.getPriceS().toString();
				higawariMPrice = cookCategory.getPriceM().toString();
				higawariIntroductions = cookCategory.getIntroductions().toString();
				higawariName = cookCategory.getItem();

			} else if (cookCategory.getId() == 4) {
				String list2 = Base64.getEncoder().encodeToString(cookCategory.getImagePath());
				model.addAttribute("omakase", list2);
				omakaseSPrice = cookCategory.getPriceS().toString();
				omakaseMPrice = cookCategory.getPriceM().toString();
				omakaseIntroductions = cookCategory.getIntroductions().toString();
				omakaseName = cookCategory.getItem();

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
		model.addAttribute("osusumeIntroductions", osusumeIntroductions);
		model.addAttribute("higawariIntroductions", higawariIntroductions);
		model.addAttribute("omakaseIntroductions", omakaseIntroductions);
		model.addAttribute("osusumeName", osusumeName);
		model.addAttribute("higawariName", higawariName);
		model.addAttribute("omakaseName", omakaseName);

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
		String hamburgerIntroductions = "";
		String yakinikuIntroductions = "";
		String chickenIntroductions = "";
		String hamburgerName = "";
		String yakinikuName = "";
		String chickenName = "";

		Iterable<CookCategory> imageData = repository.findAll();
		List<String> list = new ArrayList<>();
		for (CookCategory cookCategory : imageData) {
			String nikubentouImage = Base64.getEncoder().encodeToString(cookCategory.getImagePath());

			if (cookCategory.getId() == 7) {
				model.addAttribute("hamburger", nikubentouImage);
				hamburgerSPrice = cookCategory.getPriceS().toString();
				hamburgerMPrice = cookCategory.getPriceM().toString();
				hamburgerIntroductions = cookCategory.getIntroductions().toString();
				hamburgerName = cookCategory.getItem();

			} else if (cookCategory.getId() == 8) {
				model.addAttribute("yakiniku", nikubentouImage);
				yakinikuSPrice = cookCategory.getPriceS().toString();
				yakinikuMPrice = cookCategory.getPriceM().toString();
				yakinikuIntroductions = cookCategory.getIntroductions().toString();
				yakinikuName = cookCategory.getItem();

			} else if (cookCategory.getId() == 9) {
				model.addAttribute("chicken", nikubentouImage);
				chickenSPrice = cookCategory.getPriceS().toString();
				chickenMPrice = cookCategory.getPriceM().toString();
				chickenIntroductions = cookCategory.getIntroductions().toString();
				chickenName = cookCategory.getItem();
			}
		}
		model.addAttribute("imageData", list);
		model.addAttribute("hamburgerSPrice", hamburgerSPrice);
		model.addAttribute("hamburgerMPrice", hamburgerMPrice);
		model.addAttribute("yakinikuSPrice", yakinikuSPrice);
		model.addAttribute("yakinikuMPrice", yakinikuMPrice);
		model.addAttribute("chickenSPrice", chickenSPrice);
		model.addAttribute("chickenMPrice", chickenMPrice);
		model.addAttribute("hamburgerIntroductions", hamburgerIntroductions);
		model.addAttribute("yakinikuIntroductions", yakinikuIntroductions);
		model.addAttribute("chickenIntroductions", chickenIntroductions);
		model.addAttribute("hamburgerName", hamburgerName);
		model.addAttribute("yakinikuName", yakinikuName);
		model.addAttribute("chickenName", chickenName);

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
		String omakaseIntroductions = "";
		String sabaIntroductions = "";
		String syakeIntroductions = "";
		String omakaseName = "";
		String syakeName = "";
		String sabaName = "";
		

		Iterable<CookCategory> imageData = repository.findAll();

		List<String> list = new ArrayList<>();
		for (CookCategory cookCategory : imageData) {
			String sakanabentouImage = Base64.getEncoder().encodeToString(cookCategory.getImagePath());

			if (cookCategory.getId() == 4) {
				model.addAttribute("omakase", sakanabentouImage);
				omakaseSPrice = cookCategory.getPriceS().toString();
				omakaseMPrice = cookCategory.getPriceM().toString();
				omakaseIntroductions = cookCategory.getIntroductions().toString();
				omakaseName = cookCategory.getItem();

			} else if (cookCategory.getId() == 5) {
				model.addAttribute("syake", sakanabentouImage);
				syakeSPrice = cookCategory.getPriceS().toString();
				syakeMPrice = cookCategory.getPriceM().toString();
				syakeIntroductions = cookCategory.getIntroductions().toString();
				syakeName = cookCategory.getItem();

			} else if (cookCategory.getId() == 6) {
				model.addAttribute("saba", sakanabentouImage);
				sabaSPrice = cookCategory.getPriceS().toString();
				sabaMPrice = cookCategory.getPriceM().toString();
				sabaIntroductions = cookCategory.getIntroductions().toString();
				sabaName = cookCategory.getItem();
			}
		}

		model.addAttribute("imageData", list);
		model.addAttribute("omakaseSPrice", omakaseSPrice);
		model.addAttribute("omakaseMPrice", omakaseMPrice);
		model.addAttribute("syakeSPrice", syakeSPrice);
		model.addAttribute("syakeMPrice", syakeMPrice);
		model.addAttribute("sabaSPrice", sabaSPrice);
		model.addAttribute("sabaMPrice", sabaMPrice);
		model.addAttribute("omakaseIntroductions", omakaseIntroductions);
		model.addAttribute("sabaIntroductions", sabaIntroductions);
		model.addAttribute("syakeIntroductions", syakeIntroductions);
		model.addAttribute("omakaseName", omakaseName);
		model.addAttribute("syakeName", syakeName);
		model.addAttribute("sabaName", sabaName);

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
		String katsudonIntroductions = "";
		String yakinikubIntroductions = "";
		String oyakodonIntroductions = "";
		String katsudonName = "";
		String yakinikubName = "";
		String oyakodonName = "";

		Iterable<CookCategory> imageData = repository.findAll();

		List<String> list = new ArrayList<>();
		for (CookCategory cookCategory : imageData) {
			String donburiImage = Base64.getEncoder().encodeToString(cookCategory.getImagePath());

			if (cookCategory.getId() == 1) {
				model.addAttribute("katsudon", donburiImage);
				katsudonSPrice = cookCategory.getPriceS().toString();
				katsudonMPrice = cookCategory.getPriceM().toString();
				katsudonIntroductions = cookCategory.getIntroductions().toString();
				katsudonName = cookCategory.getItem();

			} else if (cookCategory.getId() == 2) {
				model.addAttribute("yakinikub", donburiImage);
				yakinikubSPrice = cookCategory.getPriceS().toString();
				yakinikubMPrice = cookCategory.getPriceM().toString();
				yakinikubIntroductions = cookCategory.getIntroductions().toString();
				yakinikubName = cookCategory.getItem(); 
				
			} else if (cookCategory.getId() == 3) {
				model.addAttribute("oyakodon", donburiImage);
				oyakodonSPrice = cookCategory.getPriceS().toString();
				oyakodonMPrice = cookCategory.getPriceM().toString();
				oyakodonIntroductions = cookCategory.getIntroductions().toString();
				oyakodonName = cookCategory.getItem();
			}
		}
		model.addAttribute("imageData", list);
		model.addAttribute("katsudonSPrice", katsudonSPrice);
		model.addAttribute("katsudonMPrice", katsudonMPrice);
		model.addAttribute("yakinikubSPrice", yakinikubSPrice);
		model.addAttribute("yakinikubMPrice", yakinikubMPrice);
		model.addAttribute("oyakodonSPrice", oyakodonSPrice);
		model.addAttribute("oyakodonMPrice", oyakodonMPrice);
		model.addAttribute("katsudonIntroductions", katsudonIntroductions);
		model.addAttribute("yakinikubIntroductions", yakinikubIntroductions);
		model.addAttribute("oyakodonIntroductions", oyakodonIntroductions);
		model.addAttribute("katsudonName", katsudonName);
		model.addAttribute("yakinikubName", yakinikubName);
		model.addAttribute("oyakodonName", oyakodonName);
		
		return "donburi";
	}
}

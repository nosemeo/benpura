package com.example.demo.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.ShopListDto;
import com.example.demo.entity.ShopList;
import com.example.demo.form.Form;
import com.example.demo.repository.ShopListRepository;
import com.example.demo.service.ShopListService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ShopListController {

	// セッション準備 HttpSession型のフィールドを定義する
	private HttpSession session; //若松：注文日時を保存するために必要

	@Autowired
	private ShopListRepository repository;
	@Autowired
	ShopListService shopListService;

	@Autowired //若松：注文日時を保存するために必要
	public void SessionController(HttpSession session) {
		// フィールドに代入する
		this.session = session;
	}

	//	「http://localhost:8080/shopList」
	@GetMapping("/shopList")
	public String shopListShow(Model model) {
		//		Iterable<ShopList> imagedata = repository.findAll(); ↓に変更！
		//		 EntityのデータベースのデータをRepositoryでゲットして、Serviceでどのメソッドを使うか定めて、
		//		Implで内容を書く。それをControllerで反映
		Iterable<ShopList> alldata = shopListService.selectAll();
		List<ShopListDto> shopDtoList = new ArrayList<>();

		// 写真の表示
		for (ShopList shopList : alldata) {
			// nullのデータがデータベースにあったらエラーでるのでif分でnull大丈夫にしたげる
			if (shopList.getShopPicture() != null) {
				String pictureString = Base64.getEncoder().encodeToString(shopList.getShopPicture());
				shopDtoList.add(new ShopListDto(shopList.getId(),shopList.getShopName(),shopList.getShopAddress(),shopList.getShopTel(),shopList.getShopHour(),shopList.getHoliday(),pictureString));
			}
		}
		model.addAttribute("shopLists", shopDtoList); // 左はhtml側で呼び出す為の名前
		return "shopList";
	}

	// 日付確認用にGPTが教えてくれたやつ
	@GetMapping("/check-holiday")
	// selectDateは送られてきた曜日情報が入る場所
	public String shopListCheckHoliday(Model model, Form f) {
		
		// ▼▼▼機能①▼▼▼：注文日時の曜日の取得と引き渡し
		// yyyy-MM-dd 形式の日付文字列
		LocalDate date = f.getOrderdate();
		// 取得：注文日時の曜日
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		// 変換：注文日時の曜日をString型へ
		String orderDayOfWeek = dayOfWeek.getDisplayName(java.time.format.TextStyle.FULL, Locale.JAPANESE);
		// ▲▲▲　　　▲▲▲		

		// ▼▼▼機能②▼▼▼：セッションに注文日時を保存 
		// StringをLocalTimeに変換
		LocalTime time = LocalTime.parse(f.getOrdertime(), DateTimeFormatter.ofPattern("HH:mm"));
		// LocalDateとLocalTimeを結合してLocalDateTimeを作成
		LocalDateTime orderdatetime = LocalDateTime.of(f.getOrderdate(), time);
		// ★注文日時をセッションに保存★
		this.session.setAttribute("orderdatetime", orderdatetime);
		// 再確認/再表示：保存されたユーザーネームと注文日時のセッション
		model.addAttribute("username", this.session.getAttribute("username"));
		model.addAttribute("orderdatetime", this.session.getAttribute("orderdatetime"));
		// ▲▲▲　　　▲▲▲
		
		// ▼▼▼機能③▼▼▼：お店の情報を取得
		//       getOpneShops：定休日のお店の情報は取得しない
		Iterable<ShopList> allShops = shopListService.selectAll();
		List<String> shopPicture = new ArrayList<>();
		List<ShopList> openShop = new ArrayList<>();
		
		for(ShopList shop : allShops) {
    		String holidays = shop.getHoliday();	// 店舗の休業日
    		String[] holidayArray = holidays.split("・");	// ・で区切って配列に分割
    		
    		for(String temp : holidayArray) {
    			if(!(temp==orderDayOfWeek)) {
    				for (ShopList tempShopList : allShops) {
        				// nullのデータがデータベースにあったらエラーでるのでif分でnull大丈夫にしたげる
        				if (tempShopList.getShopPicture() != null) {
        					String pictureCode = Base64.getEncoder().encodeToString(tempShopList.getShopPicture());
        					shopPicture.add(pictureCode);
        					openShop.add(tempShopList);
        				}
        			}
    			}
    			
    		}
		}
		model.addAttribute("image", shopPicture);
		model.addAttribute("shopLists", openShop); // 左はhtml側で呼び出す為の名前
		// ▲▲▲　　　▲▲▲
		
		//	public String checkHoliday(@RequestParam("selectedDay") String selectedDay,
		//								/*@RequestParam("shopName") String shopName,*/  Model model) {
		//		// 受け取った日付をパースする
		//		LocalDate date = LocalDate.parse(selectedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		//		DayOfWeek dayOfWeek = date.getDayOfWeek();
		//		String selectedDayName = dayOfWeek.name().toLowerCase(); // 曜日名を小文字で取得
		//
		//		// 店休日データの例
		//		Iterable<ShopList> alldata = shopListService.selectAll();
		//		List<ShopList> holidaylist = new ArrayList<>();
		//		
		//		// データベースから店休日を取得
		//		String holidays = shopList.getHoliday();
		//
		//		 // 店休日と選択された日付を比較
		//        boolean isHoliday = holidays != null && isHoliday(holidays, selectedDayName);
		//
		//        // モデルに結果を追加
		//        model.addAttribute("isHoliday", isHoliday); // HTMLにデータを渡す
		//        model.addAttribute("selectedDayName", selectedDayName);

		// 受け取ったselectedDayを使って処理を行う
		//		Iterable<ShopList> openShops = shopListService.getOpenShops(selectedDay);
		//		model.addAttribute("openShops",openShops);
		return "shopList";// 若松
		//        return "holidays";  // 営業中の店舗一覧を表示するHTML // 表示するHTMLファイル名
	}

	//	private boolean isHoliday(String holidays, String selectedDayName) {
	//		String[] holidayArray = holidays.split("・");
	//		for (String holiday : holidayArray) {
	//			String holidayInEnglish = convertToEnglish(holiday);
	//			if (holidayInEnglish.equalsIgnoreCase(selectedDayName)) {
	//				return true;
	//			}
	//		}
	//		return false;
	//	}
	//
	//	private String convertToEnglish(String day) {
	//		switch (day) {
	//		case "月曜":
	//			return "monday";
	//		case "火曜":
	//			return "tuesday";
	//		case "水曜":
	//			return "wednesday";
	//		case "木曜":
	//			return "thursday";
	//		case "金曜":
	//			return "friday";
	//		case "土曜":
	//			return "saturday";
	//		case "日曜":
	//			return "sunday";
	//		default:
	//			return "";
	//		}
	//	}

	//	@GetMapping("/cookCategory")
	//	public String cookCategoryshow(Model model) {
	//		CookCategory cookCategory = new CookCategory();
	////		cookCategory.showList();
	//		return "cookCategory";
	//	}

	@GetMapping("/shopInformation")
	public String shopInformationShow(Model model) {
		Iterable<ShopList> alldata2 = repository.findAll();
		List<String> list = new ArrayList<>();
		List<ShopList> list8 = new ArrayList<>();

		for (ShopList shopList : alldata2) {
			if (shopList.getShopPicture() != null) {
				String list2 = Base64.getEncoder().encodeToString(shopList.getShopPicture());
				list.add(list2);
				list8.add(shopList);
			}
		}
		model.addAttribute("image", list);
		model.addAttribute("shopLists2", list8);

		return "shopInformation";
		//		return "redirect:/cookCategory";
	}

}

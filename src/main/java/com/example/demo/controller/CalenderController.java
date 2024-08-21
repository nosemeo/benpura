package com.example.demo.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Calender;
import com.example.demo.form.Form;
import com.example.demo.service.CalenderService;

import jakarta.servlet.http.HttpSession;

@Controller
//@RequestMapping() なくても動くのでコメントアウト
public class CalenderController {

	// セッション準備 HttpSession型のフィールドを定義する
	private HttpSession session;

	@Autowired
	CalenderService service;

	@Autowired // クラスの自動生成
	public void SessionController(HttpSession session) {
		// フィールドに代入する
		this.session = session;
	}

	//htmlの呼び出し
	@GetMapping
	public String calenderShowList(Model model) {
		//注文履歴を全件取得
		Iterable<Calender> list = service.selectAll();
		//表示用「Model」への格納
		model.addAttribute("list", list);
		//calender.htmlのカレンダー、注文履歴の表示
		return "calender";
	}

	// ユーザーネームをセッションに保存
	// 再表示用
	@GetMapping("/calender2")
	public String calenderShowList2(Model model, Form f) {
		//注文履歴を全件取得
		Iterable<Calender> list = service.selectAll();

		// usernameと合致する注文履歴のみリストに追加
		List<Calender> newlist = new ArrayList<>();
		for (Calender temp : list) {
			// ログインページから読み込んだ時、ユーザー名を受け取っているか確認
			if(!(f.getUsername()==null)) {
				if (temp.getUsername().equals(f.getUsername())) {
					newlist.add(temp);
				}				
			}
			// ヘッダーのログインページから読み込んだ時、セッションにあるユーザー名を受け取っているか確認
			if(!(this.session.getAttribute("username")==null)) {
				if (temp.getUsername().equals(this.session.getAttribute("username"))) {
					newlist.add(temp);
				}				
			}
		}

		//表示用「Model」への格納
		model.addAttribute("list", newlist);

		// ユーザーネームをセッションに保存
		this.session.setAttribute("username", f.getUsername());

		//calender.htmlのカレンダー、注文履歴の表示
		return "calender";
	}

	//機能①：注文日時の曜日を取得formクラスにて受け渡し
	//
	//機能②：注文日時をセッションに保存、注文日にちと時間の結合
	//
	//その他：日時の形式を調整
	@GetMapping("/nextpage") //次のサイトが完成したらこちらに記載
	public String showNextPage(Model model, Form f) {

		// 機能①：注文日時の曜日の取得と引き渡し
		// yyyy-MM-dd 形式の日付文字列
		LocalDate date = f.getOrderdate();
		// 曜日を取得
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		// 曜日を日本語で表示
		String dayOfWeekInJapanese = dayOfWeek.getDisplayName(java.time.format.TextStyle.FULL, Locale.JAPANESE);
		
		//表示用「Model」への格納
		model.addAttribute("dayofweek", dayOfWeekInJapanese);
		
		// 機能②：セッションに注文日時を保存 
		// StringをLocalTimeに変換
		LocalTime time = LocalTime.parse(f.getOrdertime(), DateTimeFormatter.ofPattern("HH:mm"));
		// LocalDateとLocalTimeを結合してLocalDateTimeを作成
		LocalDateTime orderdatetime = LocalDateTime.of(f.getOrderdate(), time);

		// 注文日時をセッションに保存
		this.session.setAttribute("orderdatetime", orderdatetime);

		// 再確認/再表示：保存されたユーザーネームと注文日時のセッション
		model.addAttribute("username", this.session.getAttribute("username"));
		model.addAttribute("orderdatetime", this.session.getAttribute("orderdatetime"));

		// nextpage.htmlを表示
		return "nextpage";
	}
	
	// ログインページに戻るだけ
	@GetMapping("/nextpagelogin")
	public String showNextPageLogin() {
		// nextpage2.htmlを表示
		return "nextpagelogin";
	}

}

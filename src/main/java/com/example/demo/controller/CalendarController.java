package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Calendar;
import com.example.demo.service.CalendarService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CalendarController {

	//////////////////////////////////////////////////
	//  変数宣言                                    //
	//////////////////////////////////////////////////
	@Autowired
	CalendarService service;

	// セッション準備 HttpSession型のフィールドを定義する
	private HttpSession session;

	@Autowired // クラスの自動生成
	public void SessionController(HttpSession session) {
		// フィールドに代入する
		this.session = session;
	}

	//////////////////////////////////////////////////
	//  関数宣言                                    //
	//////////////////////////////////////////////////

	// ただのカレンダーの読み込み
	@GetMapping()
	public String calendarShowList(Model model) {
		System.out.println("すべてのカレンダーの読み込み");

		//注文履歴を全件取得
		Iterable<Calendar> list = service.selectAll();
		//表示用「Model」への格納
		model.addAttribute("list", list);
		//calendar.htmlのカレンダー、注文履歴の表示
		return "calendar";
	}

	// 機能：ユーザーネームをセッションに保存
	// 再表示用
	@GetMapping("/calendar")
	public String calendarShowList2(Model model, Authentication authentication) {
		System.out.println("メールアドレスで判別します。");

		String mailaddress = authentication.getName();

		System.out.println("新規" + mailaddress);
		// セッションでメールアドレス/ユーザ名を受け取り
		//		String mailaddress=(String) this.session.getAttribute("mailaddress");

		//注文履歴を全件取得
		Iterable<Calendar> list = service.selectAll();

		//
		// ★①serviceでメソッド作成  ★②注文履歴のserviceを作る
		// メソッド名sortOrder listでそんなことできるのか
		// メソッド名matchLoginidOrderlist
		//
		// mailaddressと合致する注文履歴のみリストに追加
		List<Calendar> newlist = new ArrayList<>();
		for (Calendar temp : list) {
			// ログインページから読み込んだ時
			// ユーザー名を受け取っているか確認
			if (!(mailaddress == null)) {
				if (temp.getMailaddress().equals(mailaddress)) {
					newlist.add(temp);
				}
			}
			// ヘッダーのログインページから読み込んだ時
			// セッションにあるユーザー名を受け取っているか確認
			//			if (!(this.session.getAttribute("mailaddress") == null)) {
			//				if (temp.getMailaddress().equals(mailaddress)) {
			//					newlist.add(temp);
			//				}
			//			}
		}

		// 若松：セッションの保存
		this.session.setAttribute("mailaddress", mailaddress);
		
		//表示用「Model」への格納
		model.addAttribute("list", newlist);

		//calendar.htmlのカレンダー、注文履歴の表示
		return "calendar";
	}

}

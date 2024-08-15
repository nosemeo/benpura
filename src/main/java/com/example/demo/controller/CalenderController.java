package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Calender;
import com.example.demo.form.CalenderForm;
import com.example.demo.service.CalenderService;

@Controller
//@RequestMapping() なくても動くのでコメントアウト
public class CalenderController {
	
	@Autowired
	CalenderService service;
	
	//htmlの呼び出し
	@GetMapping
	public String calenderShowList(Model model) {
		//注文履歴を全件取得
		Iterable<Calender>list=service.selectAll();
		//表示用「Model」への格納
		model.addAttribute("list",list);
		//calender.htmlのカレンダー、注文履歴の表示
		return "calender";
	}
	
	//Getリクエストとメソッドを対応つける
	@GetMapping("/nextpage") //次のサイトが完成したらこちらに記載
	public String showNextPage(CalenderForm f) {
		// nextpage.htmlを表示
		return "nextpage";
	}
	
	@GetMapping("/nextpagelogin") 
	public String showNextPageLogin() {
		// nextpagelogin.htmlを表示
		return "nextpagelogin";
	}
	
}
//  ★未解決★  エクセルに記載して質問
//  簡単①  DBにユーザーネームを追加 ※これは簡単
//  難しい⓪  注文日時の引継ぎに曜日と時間型に変換が必要
//            ↑そもそも店舗の表示にあたってこの方法が合っているか要確認
//            ステップ① htmlにて注文の日時を送信 ※曜日の処理の方法が要確認
//            ステップ② 日時をもとに定休日でない店舗の表示 ※方法
//            ↑ p.26 編集ボダンでidを取得して、該当するクイズ/店舗情報を取得
//            ↑ 1件ではなくlistで取得?
//            ↑ 条件判断はserviceでDBが取得する時に条件判断? or
//            ↑ contorll側で条件判断?
//            ↑ 要勉強：p28-29.controll側でもなぜ処理している
//
//  難しい①  前のhtmlユーザーネームの引継ぎ
//            方法の確認
//            条件判断してデータ読み込み  ログインのuser name⇔DBのuser name
//            ↑ これは時間をかければできそう
//            ↑ 上と一緒？
//  難しい②  DBから注文履歴を読み込む際に、日時の並び替えが必要
//
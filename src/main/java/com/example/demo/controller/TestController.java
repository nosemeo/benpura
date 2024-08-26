package com.example.demo.controller;


	import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class TestController {

	    @GetMapping("/api/orders/week")
	    public List<Order> getWeeklyOrders() {
	        List<Order> orders = new ArrayList<>();
	        LocalDate today = LocalDate.now();

	        // サンプルデータの生成
	        for (int i = 0; i < 7; i++) {
	            orders.add(new Order(today.plusDays(i).toString(), "注文内容 " + (i + 1)));
	        }

	        return orders;
	    }

	    static class Order {
	        private String date;
	        private String details;

	        public Order(String date, String details) {
	            this.date = date;
	            this.details = details;
	        }

	        // Getter and Setter
	        public String getDate() {
	            return date;
	        }

	        public void setDate(String date) {
	            this.date = date;
	        }

	        public String getDetails() {
	            return details;
	        }

	        public void setDetails(String details) {
	            this.details = details;
	        }
	    }
	}



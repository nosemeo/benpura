package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Calender;

public interface CalenderRepository extends CrudRepository<Calender,Integer> {
	
	//主キーの変更integer：id⇒String:usernameにより
	//repositoryも変更？
}

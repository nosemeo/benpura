package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.PersonalData;

public interface LoginUserRepository extends CrudRepository<PersonalData, String> {

}

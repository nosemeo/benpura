package com.example.demo.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.CookCategory;

public interface CookCategoryRepository extends CrudRepository<CookCategory, Integer>{
	@Query(value="SELECT * FROM public.cook_category\n"
			+ "ORDER BY id ASC ")
	Iterable<CookCategory> findAll();

}

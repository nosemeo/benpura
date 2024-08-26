package com.example.demo.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.CookCategory;

public interface CookCategoryRepository extends CrudRepository<CookCategory, Integer>{
<<<<<<< HEAD

	@Query(value="SELECT * FROM public.cook_category\n"
=======
	@Query(value="SELECT * FROM public.category_list\n"
>>>>>>> branch 'master' of https://github.com/KJ883/benpura.git
			+ "ORDER BY id ASC ")
	Iterable<CookCategory> findAll();

}

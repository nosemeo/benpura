package com.example.demo.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.PersonalData;

public interface RegisterRepository extends CrudRepository<PersonalData, String> {

	@Modifying

	@Query("INSERT INTO personal_data (username, password, fam_name_kanji, name_kanji, fam_name_furigana, name_furigana, gender, year, month, day, tel)VALUES (:username, :password, :famNameKanji, :nameKanji, :famNameFurigana, :nameFurigana, :gender, :year, :month, :day, :tel)")
	void insert(String username, String password, String famNameKanji, String nameKanji, String famNameFurigana, String nameFurigana, Boolean gender, Integer year, Integer month, Integer day, String tel);

	@Query("SELECT id FROM personal_data ORDER BY RANDOM() limit 1")
	Integer getRandomId();
	
	PersonalData findByUsername(String username);
	
	

}

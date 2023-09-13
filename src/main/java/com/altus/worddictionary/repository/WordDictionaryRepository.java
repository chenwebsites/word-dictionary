package com.altus.worddictionary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.altus.worddictionary.model.WordDictionary;

public interface WordDictionaryRepository extends JpaRepository<WordDictionary, Long> {
	
	List<WordDictionary> findByWordIgnoreCase(String word);
	
	@Query(value = "SELECT * FROM Word_Dictionary w WHERE w.word ilike %?1%", nativeQuery = true)
	List<WordDictionary> findByWordSimilarTo(String partialWord);
	
}

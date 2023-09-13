package com.altus.worddictionary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class WordDictionary {

	@Id
	@GeneratedValue
	private long id;

	@Size(min=2, message = "A word must contain at least 2 letters")
	private String word;
	
	@Size(min=10, message = "Give a detailed definition with more than 10 characters")
	private String definition;

	public WordDictionary() {
		// TODO Auto-generated constructor stub
	}

	public WordDictionary(long id, String word, String definition) {
		super();
		this.id = id;
		this.word = word;
		this.definition = definition;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	@Override
	public String toString() {
		return "Word [id=" + id + ", word=" + word + ", definition=" + definition + "]";
	}

}

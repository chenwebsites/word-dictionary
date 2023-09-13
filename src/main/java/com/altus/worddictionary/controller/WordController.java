package com.altus.worddictionary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.altus.worddictionary.model.WordDictionary;
import com.altus.worddictionary.repository.WordDictionaryRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class WordController {

	@Autowired
	private WordDictionaryRepository repository;

	@GetMapping({ "/", "index" })
	public String welcomePage(ModelMap model) {
		WordDictionary wordDictionary = new WordDictionary();
		model.addAttribute("wordDictionary", wordDictionary);
		return "index";
	}

	@PostMapping("insert")
	public String insertWord(ModelMap model, @Valid WordDictionary wordDictionary, BindingResult result) {

		if (result.hasErrors()) {
			return "index";
		}

		repository.save(wordDictionary);
		model.addAttribute("successSave", "Word and Definition saved successfuly");
		return "index";
	}

	@GetMapping("findDefinition")
	public String findDefinition(ModelMap model, @RequestParam String word) {
		List<WordDictionary> wordsList = repository.findByWordIgnoreCase(word);

		if (wordsList.isEmpty()) {
			model.put("wordNotExists", "The word does not exist in the dictionary");

		} else {
			model.addAttribute("condition", true).addAttribute("wordsList", wordsList);
		}

		return "show-words";
	}

	@GetMapping("findDefinitionByPartialWord")
	public String partialSearch(ModelMap model, @RequestParam String word) {
		List<WordDictionary> wordsList = repository.findByWordSimilarTo(word);

		if (wordsList.isEmpty()) {
			model.addAttribute("wordNotExists", "The word does not exist in the dictionary");

		} else {
			model.addAttribute("condition", true).addAttribute("wordsList", wordsList);
		}

		return "show-words";
	}

	@GetMapping("remove-word")
	public String remove(@RequestParam long id, ModelMap model, HttpServletRequest request) {
		repository.deleteById(id);
		String referer = request.getHeader("referer");
		return "redirect:" + referer;
	}

}

package com.phrase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phrase.model.Phrase;
import com.phrase.service.IPhraseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/phrase")
@CrossOrigin("*")
public class PhraseController {

	@Autowired
	private IPhraseService phraseService;
	
	@GetMapping("/random")
	public ResponseEntity<Phrase> findRandomPhrase(){
		return new ResponseEntity<Phrase>(phraseService.findRandomPhrase(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public ResponseEntity<List<Phrase>> findAll(){
		return new ResponseEntity<List<Phrase>>(phraseService.findAll(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Phrase> findById(@PathVariable("id") Long id){
		return new ResponseEntity<Phrase>(phraseService.findById(id).orElse(new Phrase()), HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public ResponseEntity<Phrase> create(@Valid @RequestBody Phrase phrase){
		return new ResponseEntity<Phrase>(phraseService.create(phrase), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Phrase> update(@Valid @RequestBody Phrase phrase){
		return new ResponseEntity<Phrase>(phraseService.update(phrase), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Phrase> delete(@PathVariable("id") Long id) {
		return new ResponseEntity<Phrase>(phraseService.delete(id), HttpStatus.ACCEPTED);
	}
}

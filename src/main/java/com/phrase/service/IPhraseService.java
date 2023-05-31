package com.phrase.service;

import java.util.List;
import java.util.Optional;

import com.phrase.model.Phrase;

public interface IPhraseService {
	List<Phrase> findAll();
	Optional<Phrase> findById(Long id);
	Phrase create(Phrase phrase);
	Phrase update(Phrase phrase);
	Phrase delete(Long id);
	Phrase findRandomPhrase();
}

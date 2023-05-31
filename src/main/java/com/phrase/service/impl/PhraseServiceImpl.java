package com.phrase.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phrase.model.Phrase;
import com.phrase.repo.IPhraseRepo;
import com.phrase.service.IPhraseService;

@Service
public class PhraseServiceImpl implements IPhraseService {

	@Autowired
	private IPhraseRepo phraseRepo;
	
	@Override
	public List<Phrase> findAll() {
		return phraseRepo.findAll();
	}

	@Override
	public Optional<Phrase> findById(Long id) {
		return phraseRepo.findById(id);
	}

	@Override
	public Phrase create(Phrase phrase) {
		return phraseRepo.save(phrase);
	}

	@Override
	public Phrase update(Phrase phrase) {
		return phraseRepo.findById(phrase.getId())
				.map(p -> phraseRepo.save(phrase))
				.orElse(this.create(phrase));
	}

	@Override
	public Phrase delete(Long id) {
		Optional<Phrase> del = phraseRepo.findById(id);
		return del
				.map(p -> {
					phraseRepo.deleteById(id);
					return del.get();
				})
				.orElse(null);
	}

	@Override
	public Phrase findRandomPhrase() {
		Random r = new Random();
		return phraseRepo.findAll().get(r.nextInt(phraseRepo.findAll().size()));
	}

}

package com.phrase.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phrase.model.Phrase;

public interface IPhraseRepo extends JpaRepository<Phrase, Long> {

}

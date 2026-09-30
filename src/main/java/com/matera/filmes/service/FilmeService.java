package com.matera.filmes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.matera.filmes.model.Filme;
import com.matera.filmes.repository.FilmeRepository;

@Service
public class FilmeService {

	private final FilmeRepository repository;

	public FilmeService(FilmeRepository repository) {
		this.repository = repository;
	}

	public List<Filme> findAll() {
		return repository.findAll();
	}

	public Optional<Filme> findOne(Long id) {
		return repository.findById(id);
	}

	public Filme save(Filme filme) {
		return repository.save(filme);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}

package com.matera.filmes.service;

import com.matera.filmes.model.Genero;
import com.matera.filmes.repository.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    private final GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public List<Genero> findAll(){
        return generoRepository.findAll();
    }
}

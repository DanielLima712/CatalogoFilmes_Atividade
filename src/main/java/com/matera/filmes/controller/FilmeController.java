package com.matera.filmes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.matera.filmes.model.Filme;
import com.matera.filmes.service.FilmeService;
import com.matera.filmes.service.GeneroService;

import jakarta.validation.Valid;

@Controller
public class FilmeController {

	private final FilmeService service;
	private final GeneroService generoService;

	public FilmeController(FilmeService service, GeneroService generoService) {
		this.service = service;
		this.generoService = generoService;
	}

	@GetMapping("/")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("filme");
		mv.addObject("filmes", service.findAll());
		return mv;
	}

	@GetMapping("/add")
	public ModelAndView add(Filme filme) {
		ModelAndView mv = new ModelAndView("filmeAdd");
		mv.addObject("filme", filme);
		mv.addObject("generos", generoService.findAll());
		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Filme filme = service.findOne(id).get();
		return add(filme);
	}

	@PostMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		service.delete(id);
		return new ModelAndView("redirect:/");
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Filme filme, BindingResult result) {
		if (result.hasErrors()) {
			return add(filme);
		}
		service.save(filme);
		return new ModelAndView("redirect:/");
	}
}

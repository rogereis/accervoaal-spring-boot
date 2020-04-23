package com.braga.henrique.cartas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.braga.henrique.cartas.model.Pessoa;
import com.braga.henrique.cartas.service.PessoaService;

@RestController
public class PessoaController {
	
	@Autowired
	PessoaService service;
	
	final ModelAndView modelAndView = new ModelAndView();
	
	@GetMapping("/pessoa")
	public ModelAndView listar() {
		modelAndView.setViewName("pessoa");
		
		//List<Pessoa> pessoas = service.findAllByOrderByNomeAsc();

		modelAndView.addObject("todasPessoas",null);

		return modelAndView;
	}
	
	@GetMapping("/pessoa/search")
	public ModelAndView search(@RequestParam(value = "nome") final String nome) {
		modelAndView.setViewName("pessoa");
		
		List<Pessoa> pessoas = service.findByNomeContainingIgnoreCase(nome);
		
		modelAndView.addObject("todasPessoas",pessoas);

		return modelAndView;
	}

	
}

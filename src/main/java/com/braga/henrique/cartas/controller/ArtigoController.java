package com.braga.henrique.cartas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.braga.henrique.cartas.model.Arquivo;
import com.braga.henrique.cartas.model.Artigo;
import com.braga.henrique.cartas.model.Pessoa;
import com.braga.henrique.cartas.repository.ArquivoRepository;
import com.braga.henrique.cartas.repository.PessoaRepository;
import com.braga.henrique.cartas.service.ArtigoService;

@RestController
public class ArtigoController {

	@Autowired
	ArtigoService service;
	
	@Autowired
	PessoaRepository repository;
	
	@Autowired
	ArquivoRepository arquivoRepository;

	final ModelAndView modelAndView = new ModelAndView();

	@GetMapping("/artigos")
	public ModelAndView listar() {
		modelAndView.setViewName("artigo");

		// modelAndView.addObject("todosArtigos",service.findAll());

		return modelAndView;
	}

	@GetMapping("/search")
	public ModelAndView search(@RequestParam(value = "nome") final String nome) {

		final ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("artigo");

		modelAndView.addObject("todosArtigos", service.findByNomeContainingIgnoreCase(nome));

		return modelAndView;

	}
	
	@GetMapping("/criarPessoa")
	public ModelAndView criarPessoa() {

		final ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("artigo");

		List<Artigo> todosArtigos = service.findAll();
		Long id = 0L;
		for(Artigo p: todosArtigos) {
			List<Arquivo> arquivos = new ArrayList<Arquivo>();
			
			Pessoa pessoa = service.findByNome(p.getNome());
			
			if (id.equals(pessoa.getId()) || id.equals(0L)) {
				Arquivo arquivo = new Arquivo(p.getEnderecoPDF());
				arquivoRepository.save(arquivo);
				arquivos.add(arquivoRepository.save(arquivo));
			} else {
				repository.save(pessoa);
				arquivos = new ArrayList<Arquivo>();
			}
			 
			
		}

		return modelAndView;

	}


}

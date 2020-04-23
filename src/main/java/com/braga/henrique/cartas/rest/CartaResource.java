package com.braga.henrique.cartas.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.braga.henrique.cartas.model.Pessoa;
import com.braga.henrique.cartas.service.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
public class CartaResource {

	@Autowired
	private PessoaService service;
	
	@GetMapping("/")
	public List<Pessoa> get() {
		return new ArrayList<Pessoa>();
	}
	
	@GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Pessoa>> procura(@RequestParam("nome") String nome) {
		List<Pessoa> pessoas = service.findByNomeContainingIgnoreCase(nome);
		return ResponseEntity.status(HttpStatus.OK).body(pessoas);
	}
	
	@GetMapping("/search2")
	public List<String> procura2(@RequestParam("nome") String nome) {
		List<String> nomes = new ArrayList<String>();
		for(Pessoa p: service.findByNomeContainingIgnoreCase(nome)) {
			nomes.add(p.getNome());
		}
			
		return nomes;
	}
}

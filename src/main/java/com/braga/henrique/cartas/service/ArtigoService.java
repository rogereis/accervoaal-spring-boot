package com.braga.henrique.cartas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.braga.henrique.cartas.model.Artigo;
import com.braga.henrique.cartas.model.Pessoa;
import com.braga.henrique.cartas.repository.ArtigosRepository;
import com.braga.henrique.cartas.repository.PessoaRepository;

@Service
public class ArtigoService {
	
	@Autowired
	private ArtigosRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Artigo> findAll() {
		return repository.findAll();
	}

	public List<Artigo> findByNomeContainingIgnoreCase(String nome) {
		return repository.findByNomeContainingIgnoreCase(nome);		
	}

	public List<String> findDistinctNomes() {
		// TODO Auto-generated method stub
		return repository.findDistinctNomes();
	}

	public Pessoa findByNome(String nome) {
		return pessoaRepository.findByNome(nome);
	}
}

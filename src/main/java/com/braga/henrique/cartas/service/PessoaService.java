package com.braga.henrique.cartas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.braga.henrique.cartas.model.Pessoa;
import com.braga.henrique.cartas.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository repository;

	public List<Pessoa> findAll() {
		return repository.findAll();
	}

	public List<Pessoa> findAllByOrderByNomeAsc() {
		// TODO Auto-generated method stub
		return repository.findAllByOrderByNomeAsc();
	}

	public List<Pessoa> findByNomeContainingIgnoreCase(String nome) {
		// TODO Auto-generated method stub
		return repository.findByNomeContainingIgnoreCase(nome);
	}

	public Optional<Pessoa> findById(Long i) {
		// TODO Auto-generated method stub
		return repository.findById(i);
	}
}

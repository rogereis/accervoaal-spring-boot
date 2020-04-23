package com.braga.henrique.cartas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.braga.henrique.cartas.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	Pessoa findByNome(String nome);

	List<Pessoa> findAllByOrderByNomeAsc();

	List<Pessoa> findByNomeContainingIgnoreCase(String nome);

}

package com.braga.henrique.cartas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.braga.henrique.cartas.model.Artigo;
import com.braga.henrique.cartas.model.Pessoa;

@Repository
public interface ArtigosRepository extends JpaRepository<Artigo, Long>{

	List<Artigo> findByNomeContainingIgnoreCase(String nome);

	@Query("select distinct a.nome from Artigo a")
	List<String> findDistinctNomes();

	Pessoa findByNome(String nome);

}

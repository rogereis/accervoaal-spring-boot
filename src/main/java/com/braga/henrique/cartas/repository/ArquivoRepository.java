package com.braga.henrique.cartas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.braga.henrique.cartas.model.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Long>{

}

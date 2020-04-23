package com.braga.henrique.cartas.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Arquivo {
	
	@Id
	@SequenceGenerator(name="seq-gen-arquivo",sequenceName="arquivo_id_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen-arquivo")
	private Long id;
	
	@Column(name="endereco_pdf")
	private String enderecoPDF;
	
//	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
//	@JoinTable(name="PESSOA_ARQUIVO",joinColumns = @JoinColumn(name="ID_ARQUIVO"),inverseJoinColumns = @JoinColumn(name="ID_PESSOA"))
//	private List<Pessoa> pessoas;
	
	public Arquivo() {
		super();
	}

	public Arquivo(String enderecoPDF) {
		super();
		this.enderecoPDF = enderecoPDF;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnderecoPDF() {
		return enderecoPDF.toLowerCase();
	}

	public void setEnderecoPDF(String enderecoPDF) {
		this.enderecoPDF = enderecoPDF;
	}

//	public List<Pessoa> getPessoas() {
//		return pessoas;
//	}
//
//	public void setPessoas(List<Pessoa> pessoas) {
//		this.pessoas = pessoas;
//	}

}

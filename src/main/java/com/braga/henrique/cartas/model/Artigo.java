package com.braga.henrique.cartas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artigo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="id_doc")
	private Long idDocumento;

	@Column(name="nome")
	private String nome;
	
	@Column(name="endereco_pdf")
	private String enderecoPDF;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEnderecoPDF() {
		return enderecoPDF.toLowerCase();
	}

	public void setEnderecoPDF(String enderecoPDF) {
		this.enderecoPDF = enderecoPDF;
	}
}

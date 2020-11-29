package com.ezequias.apiestudo.dto;

import java.io.Serializable;
import java.util.Date;

import com.ezequias.apiestudo.domain.enums.Cargo;
import com.fasterxml.jackson.annotation.JsonFormat;

public class VendedorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id ;
	private String nome;
	private Long metaId;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date nascimento;
	
	public VendedorDTO() {	
	}

	public VendedorDTO(Integer id, String nome, Date nascimento, Long metaId) {
		super();
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.metaId = metaId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Long getMetaId() {
		return metaId;
	}

	public void setMetaId(Long metaId) {
		this.metaId = metaId;
	}
	
}

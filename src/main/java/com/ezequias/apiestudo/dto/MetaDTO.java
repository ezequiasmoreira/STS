package com.ezequias.apiestudo.dto;

import java.io.Serializable;
import java.util.Date;

import com.ezequias.apiestudo.domain.enums.Cargo;
import com.fasterxml.jackson.annotation.JsonFormat;

public class MetaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id ;
	private Double valor;
	private String descricao;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataReferencia;
	private Double comissao;
	
	public MetaDTO() {	
	}

	
	public MetaDTO(Integer id, Double valor, String descricao, Date dataReferencia, Double comissao) {
		super();
		this.id = id;
		this.valor = valor;
		this.descricao = descricao;
		this.dataReferencia = dataReferencia;
		this.comissao = comissao;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataReferencia() {
		return dataReferencia;
	}

	public void setDataReferencia(Date dataReferencia) {
		this.dataReferencia = dataReferencia;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	
}

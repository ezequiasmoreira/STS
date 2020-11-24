package com.ezequias.apiestudo.dto;

import java.io.Serializable;
import java.util.Date;

import com.ezequias.apiestudo.domain.enums.Cargo;
import com.fasterxml.jackson.annotation.JsonFormat;

public class SalarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer cargo;
	private Integer funcionarioId;
	private Double salarioLiquido;
	private Double salarioBruto;
	private Double desconto;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataReferencia;
	
	public SalarioDTO() {	
	}

	public SalarioDTO(Integer id, Integer funcionarioId, Double salarioBruto, Double desconto,	Date dataReferencia) {
		super();
		this.id = id;
		this.funcionarioId = funcionarioId;
		this.salarioBruto = salarioBruto;
		this.desconto = desconto;
		this.dataReferencia = dataReferencia;
	}

	public Integer getId() {
		return id;
	}

	public Integer getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Integer funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo.getCod();
	}

	public Double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(Double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public Double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(Double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Date getDataReferencia() {
		return dataReferencia;
	}

	public void setDataReferencia(Date dataReferencia) {
		this.dataReferencia = dataReferencia;
	}
	
	
}

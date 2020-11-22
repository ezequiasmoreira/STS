package com.ezequias.apiestudo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Vendedor extends Funcionario{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="meta_id")
	private Meta meta;
	
	@OneToMany
	@JoinColumn(name="vendedor_id")
	private List<Salario> salarios = new ArrayList<>();

	public Vendedor() {
		
	}
	
	public Vendedor(Integer id, String nome, Date nascimento,Meta meta) {
		super(id,nome,nascimento);	
		this.meta = meta;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public List<Salario> getSalarios() {
		return salarios;
	}

	public void setSalarios(List<Salario> salarios) {
		this.salarios = salarios;
	}
	
	


}

package com.ezequias.apiestudo.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ezequias.apiestudo.domain.enums.Cargo;

@Entity
public class Vendedor extends Funcionario{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="meta_id")
	private Meta meta;
	
	public Vendedor() {
		this.setCargo(Cargo.VENDEDOR);
	}
	
	public Vendedor(Integer id, String nome, Date nascimento,Meta meta) {
		super(id,nome,nascimento);	
		this.setCargo(Cargo.VENDEDOR);
		this.meta = meta;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}
}

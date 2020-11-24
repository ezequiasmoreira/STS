package com.ezequias.apiestudo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ezequias.apiestudo.domain.enums.Cargo;

@Entity
public class Representante extends Funcionario{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="meta_id")
	private Meta meta;

	public Representante() {
		this.setCargo(Cargo.REPRESENTANTE);
	}
	
	public Representante(Integer id, String nome, Date nascimento, Meta meta) {
		super(id,nome,nascimento);
		this.setCargo(Cargo.REPRESENTANTE);
		this.meta = meta;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}


}

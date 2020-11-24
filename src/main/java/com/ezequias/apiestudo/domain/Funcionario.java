package com.ezequias.apiestudo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ezequias.apiestudo.domain.enums.Cargo;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Inheritance;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Funcionario implements Serializable{	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date nascimento;
	
	private Integer cargo;
	
	@OneToMany
	@JoinColumn(name="funcionario_id")
	private List<Salario> salarios = new ArrayList<>();
	
	public Funcionario() {		
	}

	public Funcionario(Integer id, String nome, Date nascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
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
	
	public List<Salario> getSalarios() {
		return salarios;
	}

	public void setSalarios(List<Salario> salarios) {
		this.salarios = salarios;
	}
	
	public void setCargo(Cargo cargo) {
		this.cargo = cargo.getCod();
	}

	public Cargo getCargo() {
		return Cargo.toEnum(cargo);
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}


package com.ezequias.apiestudo.services;

import com.ezequias.apiestudo.domain.Meta;
import com.ezequias.apiestudo.domain.Salario;
import com.ezequias.apiestudo.specs.MetaSpec;

public class MetaService {
	private MetaSpec metaSpec;
	public Salario calcularComissao (Salario salario,Meta meta) {
		
		Boolean geraComissao =  metaSpec.geraComissao(salario, meta);
		
		if (geraComissao == true) {
			Double comissao = salario.getSalarioLiquido() * (meta.getComissao() /100);
			salario.setSalarioLiquido(salario.getSalarioLiquido() + comissao);
		}
		
		return salario;
	}

}

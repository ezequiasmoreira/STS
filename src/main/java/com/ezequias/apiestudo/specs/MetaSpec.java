package com.ezequias.apiestudo.specs;

import org.springframework.stereotype.Service;

import com.ezequias.apiestudo.domain.Meta;
import com.ezequias.apiestudo.domain.Salario;

@Service
public class MetaSpec {
	
	public Boolean geraComissao (Salario salario,Meta meta) {
		
		if(salario.getSalarioLiquido() >= meta.getValor()) {
			return true;
		}
		
		return false;
	}

}

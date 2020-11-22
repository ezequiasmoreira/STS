package com.ezequias.apiestudo.specs;

import com.ezequias.apiestudo.domain.Meta;
import com.ezequias.apiestudo.domain.Salario;

public class MetaSpec {
	
	public Boolean geraComissao (Salario salario,Meta meta) {
		
		if(salario.getSalarioLiquido() >= meta.getValor()) {
			return true;
		}
		
		return false;
	}

}

package com.ezequias.apiestudo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezequias.apiestudo.domain.Meta;
import com.ezequias.apiestudo.domain.Salario;
import com.ezequias.apiestudo.domain.Vendedor;
import com.ezequias.apiestudo.domain.enums.Cargo;
import com.ezequias.apiestudo.dto.SalarioDTO;

@Service
public class SalarioService {
	@Autowired
	private MetaService metaService;
	
	public Salario calcularSalario(SalarioDTO salarioDTO) {
		Salario salario = new Salario();
		Meta meta = obterMetaPor(salarioDTO);
		
		salario.setDataReferencia(new Date());
		salario.setCargo(salarioDTO.getCargo());
		salario.setDesconto(salarioDTO.getDesconto());
		salario.setSalarioBruto(salarioDTO.getSalarioBruto());
		salario.setSalarioLiquido(salario.getSalarioBruto() - salario.getDesconto());
		
		salario = metaService.calcularComissao(salario,meta);
		
		vincularSalario(salarioDTO,salario);
		
		return salario;
	}
	
	public Meta obterMetaPor(SalarioDTO salarioDTO) {
		
		if (salarioDTO.getCargo().equals(Cargo.VENDEDOR)) {
			Vendedor obj = new Vendedor();
			return obj.getMeta();
		}
		
		return new Meta();

	}
	
public void vincularSalario(SalarioDTO salarioDTO, Salario salario) {
		
		if (salarioDTO.getCargo().equals(Cargo.VENDEDOR)) {
			Vendedor obj = new Vendedor();
			obj.getSalarios().add(salario);
		}		
	}

}

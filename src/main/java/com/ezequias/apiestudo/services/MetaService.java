package com.ezequias.apiestudo.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezequias.apiestudo.domain.Meta;
import com.ezequias.apiestudo.domain.Salario;
import com.ezequias.apiestudo.dto.MetaDTO;
import com.ezequias.apiestudo.repositorys.MetaRepository;
import com.ezequias.apiestudo.specs.MetaSpec;

@Service
public class MetaService {	
	@Autowired
	private MetaSpec metaSpec;
	
	@Autowired
	private MetaRepository metaRepository;
	
	public Salario calcularComissao (Salario salario,Meta meta) {
		
		Boolean geraComissao =  metaSpec.geraComissao(salario, meta);
		
		if (geraComissao == true) {
			Double comissao = salario.getSalarioLiquido() * (meta.getComissao() /100);
			salario.setSalarioLiquido(salario.getSalarioLiquido() + comissao);
		}
		
		return salario;
	}
	
	public Meta salvar(MetaDTO metaDTO) {
		Meta meta = new Meta();
		
		meta.setId(null);
		meta.setValor(metaDTO.getValor());
		meta.setComissao(metaDTO.getComissao());
		meta.setDescricao(metaDTO.getDescricao());
		meta.setDataReferencia(metaDTO.getDataReferencia());
		
		metaRepository.save(meta);
		
		return meta;
	}
	
	public Meta obterPorId(Long id) {
		return metaRepository.obterPorId(id);
	}

}

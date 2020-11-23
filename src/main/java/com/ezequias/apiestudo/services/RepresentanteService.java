package com.ezequias.apiestudo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezequias.apiestudo.domain.Meta;
import com.ezequias.apiestudo.domain.Representante;
import com.ezequias.apiestudo.domain.Salario;
import com.ezequias.apiestudo.domain.Vendedor;
import com.ezequias.apiestudo.dto.MetaDTO;
import com.ezequias.apiestudo.dto.RepresentanteDTO;
import com.ezequias.apiestudo.dto.VendedorDTO;
import com.ezequias.apiestudo.repositorys.RepresentanteRepository;
import com.ezequias.apiestudo.repositorys.VendedorRepository;

@Service
public class RepresentanteService {
	
	@Autowired
	private MetaService metaService;
	
	@Autowired
	private RepresentanteRepository representanteRepository;
	
	public Representante salvar(RepresentanteDTO representanteDTO) {
		Representante representante = new Representante();
		
		representante.setId(null);
		representante.setNome(representanteDTO.getNome());
		representante.setNascimento(representanteDTO.getNascimento());
		representante.setMeta(metaService.obterPorId(representanteDTO.getMetaId()));
		
		representanteRepository.save(representante);
		
		return representante;
	}
	
	public Representante obterPorId(Integer id) {
		return representanteRepository.obterPorId(id);
	}
	
	public Representante vincularSalario(Representante representante, Salario salario) {
		representante.getSalarios().add(salario);
		return representanteRepository.save(representante);
	}

}

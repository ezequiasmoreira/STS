package com.ezequias.apiestudo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezequias.apiestudo.domain.Meta;
import com.ezequias.apiestudo.domain.Vendedor;
import com.ezequias.apiestudo.dto.MetaDTO;
import com.ezequias.apiestudo.dto.VendedorDTO;
import com.ezequias.apiestudo.repositorys.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private MetaService metaService;
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	public Vendedor salvar(VendedorDTO vendedorDTO) {
		Vendedor vendedor = new Vendedor();
		
		vendedor.setId(null);
		vendedor.setNome(vendedorDTO.getNome());
		vendedor.setNascimento(vendedorDTO.getNascimento());
		vendedor.setMeta(metaService.obterPorId(vendedorDTO.getMetaId()));
		
		vendedorRepository.save(vendedor);
		
		return vendedor;
	}

}

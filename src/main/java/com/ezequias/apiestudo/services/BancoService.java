package com.ezequias.apiestudo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezequias.apiestudo.domain.Meta;
import com.ezequias.apiestudo.domain.Representante;
import com.ezequias.apiestudo.domain.Salario;
import com.ezequias.apiestudo.domain.Vendedor;
import com.ezequias.apiestudo.domain.enums.Cargo;
import com.ezequias.apiestudo.dto.MetaDTO;
import com.ezequias.apiestudo.dto.RepresentanteDTO;
import com.ezequias.apiestudo.dto.SalarioDTO;
import com.ezequias.apiestudo.dto.VendedorDTO;

@Service
public class BancoService {
	
	@Autowired
	private MetaService metaService;
	
	@Autowired
	private VendedorService vendedorService;	
	
	@Autowired
	private RepresentanteService representanteService;
	
	public void instanciarBanco() throws ParseException {
		Meta metaVendedores = criarMeta("Meta/Vendedores",1);
		Meta metaRepresentantes = criarMeta("Meta/Representantes",2);
		
		Vendedor vendedor1 = criarVendedor(metaVendedores, "João da Silva");
		Vendedor vendedor2 = criarVendedor(metaVendedores, "Pedro da Silva");
		
		Representante representante1 = criarRepresentante(metaRepresentantes, "Maria da silva");
		Representante representante2 = criarRepresentante(metaRepresentantes, "Jose da silva");
		
	}
	
	public Meta criarMeta(String descricao,Integer multiplicador ) throws ParseException {	
		
		MetaDTO metaDTO = new MetaDTO();		
		Date dataReferencia = new Date();		
		
		metaDTO.setValor(400.00 * multiplicador);
		metaDTO.setComissao(5.00 * multiplicador);
		metaDTO.setDescricao(descricao);
		metaDTO.setDataReferencia(dataReferencia);
		
		return metaService.salvar(metaDTO);		
	}
	
	public Vendedor criarVendedor(Meta meta,String nome ) throws ParseException {	
		
		VendedorDTO vendedorDTO = new VendedorDTO();		
		Date nascimento = new Date();		
		
		vendedorDTO.setId(null);
		vendedorDTO.setNome(nome);
		vendedorDTO.setNascimento(nascimento);
		vendedorDTO.setMetaId(meta.getId());
		
		return vendedorService.salvar(vendedorDTO);
	}
	
public Representante criarRepresentante(Meta meta,String nome ) throws ParseException {	
		
		RepresentanteDTO representanteDTO = new RepresentanteDTO();		
		Date nascimento = new Date();		
		
		representanteDTO.setId(null);
		representanteDTO.setNome(nome);
		representanteDTO.setNascimento(nascimento);
		representanteDTO.setMetaId(meta.getId());
		
		return representanteService.salvar(representanteDTO);
	}
	
	
	

}

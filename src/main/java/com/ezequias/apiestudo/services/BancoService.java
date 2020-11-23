package com.ezequias.apiestudo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezequias.apiestudo.domain.Meta;
import com.ezequias.apiestudo.domain.Salario;
import com.ezequias.apiestudo.domain.Vendedor;
import com.ezequias.apiestudo.domain.enums.Cargo;
import com.ezequias.apiestudo.dto.MetaDTO;
import com.ezequias.apiestudo.dto.SalarioDTO;

@Service
public class BancoService {
	
	@Autowired
	private MetaService metaService;
	
	public void instanciarBanco() throws ParseException {
		Meta metaVendedores = criarMeta("Meta/Vendedores",1);
		Meta metaRepresentantes = criarMeta("Meta/Representantes",2);
		
	}
	
	public Meta criarMeta(String descricao,Integer multiplicador ) throws ParseException {	
		
		MetaDTO metaDTO = new MetaDTO();		
		Date dataReferencia = new Date();		
		
		metaDTO.setValor(400.00 * multiplicador);
		metaDTO.setComissao(5.00 * multiplicador);
		metaDTO.setDescricao(descricao);
		metaDTO.setDataReferencia(dataReferencia);
		
		//MetaService metaService = new MetaService();
		Meta meta = metaService.salvar(metaDTO);
		
		return meta;		
	}
	
	

}

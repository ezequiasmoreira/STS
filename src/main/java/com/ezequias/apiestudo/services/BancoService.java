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
	private SalarioService salarioService;
	
	@Autowired
	private RepresentanteService representanteService;
	
	public void instanciarBanco() throws ParseException {
		Meta metaVendedores = criarMeta("Meta/Vendedores",1);
		Meta metaRepresentantes = criarMeta("Meta/Representantes",2);
		
		Vendedor vendedor1 = criarVendedor(metaVendedores, "João da Silva");
		Vendedor vendedor2 = criarVendedor(metaVendedores, "Pedro da Silva");
		
		Representante representante1 = criarRepresentante(metaRepresentantes, "Maria da silva");
		Representante representante2 = criarRepresentante(metaRepresentantes, "Jose da silva");
		
		Salario salario1 = criarSalario(vendedor1);
		vendedorService.vincularSalario(vendedor1, salario1);
		Salario salario2 = criarSalario(vendedor1);
		vendedorService.vincularSalario(vendedor1, salario2);
		
		Salario salario3 = criarSalario(vendedor2);
		vendedorService.vincularSalario(vendedor2, salario3);
		
		Salario salario4 = criarSalario(representante1);
		representanteService.vincularSalario(representante1, salario4);
		Salario salario5 = criarSalario(representante1);
		representanteService.vincularSalario(representante1, salario5);
		
		Salario salario6 = criarSalario(representante2);
		representanteService.vincularSalario(representante2, salario6);	
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
	
	public Salario criarSalario(Vendedor vendedor ) throws ParseException {	
		
		SalarioDTO salarioDTO = new SalarioDTO();	
		Date dataReferencia = new Date();
		
		salarioDTO.setId(null);
		salarioDTO.setCargo(Cargo.VENDEDOR);
		salarioDTO.setDataReferencia(dataReferencia);
		salarioDTO.setSalarioBruto(1000.00);
		salarioDTO.setDesconto(100.00);
		salarioDTO.setEntidadeId(vendedor.getId());
		
		return salarioService.salvar(salarioDTO);
	}
	
	public Salario criarSalario(Representante representante ) throws ParseException {	
		
		SalarioDTO salarioDTO = new SalarioDTO();	
		Date dataReferencia = new Date();
		
		salarioDTO.setId(null);
		salarioDTO.setCargo(Cargo.REPRESENTANTE);
		salarioDTO.setDataReferencia(dataReferencia);
		salarioDTO.setSalarioBruto(1000.00);
		salarioDTO.setDesconto(100.00);
		salarioDTO.setEntidadeId(representante.getId());
		
		return salarioService.salvar(salarioDTO);
	}
	
	
	

}

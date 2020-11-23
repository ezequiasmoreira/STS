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
import com.ezequias.apiestudo.repositorys.SalarioRepository;

@Service
public class SalarioService {
	@Autowired
	private MetaService metaService;
	
	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private RepresentanteService representanterService;
	
	@Autowired
	private SalarioRepository salarioRepository;
	
	
	public Salario calcularSalario(SalarioDTO salarioDTO) {
		Salario salario = new Salario();
		Meta meta = obterMetaPor(salarioDTO);
		
		salario.setDataReferencia(new Date());
		salario.setCargo(salarioDTO.getCargo());
		salario.setDesconto(salarioDTO.getDesconto());
		salario.setSalarioBruto(salarioDTO.getSalarioBruto());
		salario.setSalarioLiquido(salario.getSalarioBruto() - salario.getDesconto());
		
		salario = metaService.calcularComissao(salario,meta);
		
		return salario;
	}
	
	public Meta obterMetaPor(SalarioDTO salarioDTO) {
		
		if (salarioDTO.getCargo().equals(Cargo.VENDEDOR.getCod())) {
			return vendedorService.obterPorId(salarioDTO.getEntidadeId()).getMeta();
		}
		
		return representanterService.obterPorId(salarioDTO.getEntidadeId()).getMeta();
	}
	
	public void vincularSalario(SalarioDTO salarioDTO, Salario salario) {
		
		if (salarioDTO.getCargo().equals(Cargo.VENDEDOR.getCod())) {
			vendedorService.vincularSalario(vendedorService.obterPorId(salarioDTO.getEntidadeId()),salario);			
		}
		
		representanterService.vincularSalario(representanterService.obterPorId(salarioDTO.getEntidadeId()),salario);
	}
	
	public Salario salvar(SalarioDTO salarioDTO) {
		
		Salario salario = calcularSalario(salarioDTO);
		
		return salarioRepository.save(salario);
	}

}

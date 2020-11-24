package com.ezequias.apiestudo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezequias.apiestudo.domain.Funcionario;
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
	private RepresentanteService representanteService;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private SalarioRepository salarioRepository;	
	
	public Salario calcularSalario(SalarioDTO salarioDTO) {
		Salario salario = new Salario();	
		
		salario.setDataReferencia(new Date());
		salario.setCargo(salarioDTO.getCargo());
		salario.setDesconto(salarioDTO.getDesconto());
		salario.setSalarioBruto(salarioDTO.getSalarioBruto());
		salario.setSalarioLiquido(salario.getSalarioBruto() - salario.getDesconto());
		salario.setFuncionario(funcionarioService.obterPorId(salarioDTO.getFuncionarioId()));
		
		Meta meta = obterMetaPor(salario.getFuncionario());
		salario = metaService.calcularComissao(salario,meta);
		
		return salario;
	}
	
	public Meta obterMetaPor(Funcionario funcionario) {
		
		if (funcionario.getCargo().equals(Cargo.VENDEDOR)) {
			return vendedorService.obterPorId(funcionario.getId()).getMeta();
		}
		
		return representanteService.obterPorId(funcionario.getId()).getMeta();
	}
	
	public void vincularSalario(Salario salario) {
		
		if (salario.getFuncionario().getCargo().equals(Cargo.VENDEDOR)) {
			vendedorService.vincularSalario(vendedorService.obterPorId(salario.getFuncionario().getId()),salario);			
		}
		
		representanteService.vincularSalario(representanteService.obterPorId(salario.getFuncionario().getId()),salario);
	}
	
	public Salario salvar(SalarioDTO salarioDTO) {
		
		Salario salario = calcularSalario(salarioDTO);
		
		return salarioRepository.save(salario);
	}

}

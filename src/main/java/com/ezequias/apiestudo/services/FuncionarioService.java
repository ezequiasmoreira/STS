package com.ezequias.apiestudo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezequias.apiestudo.domain.Funcionario;
import com.ezequias.apiestudo.repositorys.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
		
	public Funcionario obterPorId(Integer id) {
		return funcionarioRepository.obterPorId(id);
	}
}

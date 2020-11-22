package com.ezequias.apiestudo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ezequias.apiestudo.domain.Funcionario;

@RestController
@RequestMapping(value="funcionarios")
public class FuncionarioResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Funcionario> listar() {
		Funcionario f1 = new Funcionario(1, "João");
		Funcionario f2 = new Funcionario(2, "Marcos");
		
		List<Funcionario> listaFuncionarios = new ArrayList<>();

		listaFuncionarios.add(f1);
		listaFuncionarios.add(f2);
		return listaFuncionarios;
	}
}

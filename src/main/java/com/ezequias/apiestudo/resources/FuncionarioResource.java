package com.ezequias.apiestudo.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public List<Funcionario> listar() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Funcionario f1 = new Funcionario(1, "João",sdf.parse("01/01/2000 10:32"));
		Funcionario f2 = new Funcionario(2, "Marcos",sdf.parse("01/01/1992 10:32"));
		
		List<Funcionario> listaFuncionarios = new ArrayList<>();

		listaFuncionarios.add(f1);
		listaFuncionarios.add(f2);
		return listaFuncionarios;
	}
}

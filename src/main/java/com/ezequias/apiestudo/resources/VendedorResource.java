package com.ezequias.apiestudo.resources;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ezequias.apiestudo.domain.Meta;
import com.ezequias.apiestudo.domain.Salario;
import com.ezequias.apiestudo.domain.Vendedor;
import com.ezequias.apiestudo.domain.enums.Cargo;
import com.ezequias.apiestudo.dto.SalarioDTO;
import com.ezequias.apiestudo.services.SalarioService;
import com.ezequias.apiestudo.services.VendedorService;

@RestController
@RequestMapping(value="vendedores")
public class VendedorResource {
	private SalarioService salarioService;
	
	@RequestMapping(value="salario", method = RequestMethod.POST)
	public ResponseEntity<Void> adicionarSalario(@RequestBody SalarioDTO salarioDTO){
		salarioDTO.setCargo(Cargo.VENDEDOR);
		Salario obj = salarioService.calcularSalario(salarioDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
	}

}

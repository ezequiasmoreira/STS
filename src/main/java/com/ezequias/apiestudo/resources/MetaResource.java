package com.ezequias.apiestudo.resources;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ezequias.apiestudo.domain.Meta;
import com.ezequias.apiestudo.domain.Salario;
import com.ezequias.apiestudo.domain.Vendedor;
import com.ezequias.apiestudo.domain.enums.Cargo;
import com.ezequias.apiestudo.dto.MetaDTO;
import com.ezequias.apiestudo.dto.SalarioDTO;
import com.ezequias.apiestudo.services.MetaService;
import com.ezequias.apiestudo.services.SalarioService;
import com.ezequias.apiestudo.services.VendedorService;

@RestController
@RequestMapping(value="metas")
public class MetaResource {
	@Autowired
	private MetaService metaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody MetaDTO metaDTO){
		Meta obj = metaService.salvar(metaDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Meta> obterPorId(@PathVariable Long id){
		if(id < 1){
			return ResponseEntity.badRequest().build();
		}
		Meta obj = metaService.obterPorId(id);
		if(obj == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(obj);
	}

}

package com.ezequias.apiestudo.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ezequias.apiestudo.services.BancoService;

@Configuration
@Profile("devPgadm")
public class DevConfig {
	@Autowired
	BancoService bancoService;
	
	@Bean
	public boolean instanciateDataBase() throws ParseException {
		bancoService.instanciarBanco();
		return true;
			
	}

}

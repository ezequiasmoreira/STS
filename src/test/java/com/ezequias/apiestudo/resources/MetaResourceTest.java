package com.ezequias.apiestudo.resources;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.ezequias.apiestudo.domain.Meta;
import com.ezequias.apiestudo.services.MetaService;

import io.restassured.http.ContentType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest
public class MetaResourceTest {

	@Autowired
	private MetaResource metaResouce;
	
	@MockBean
	private MetaService metaService;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.metaResouce);
	}
	
	@Test
	public void deveRetornarSucesso_QuandoBuscarMeta() {
		
		when(this.metaService.obterPorId(1L))
			.thenReturn(new Meta(1L, 500.00, "Meta para vendedores", new Date(), 5.00));
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/metas/{id}", 1L)
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarNaoEncontrado_QuandoBuscarMeta() {
		when(this.metaService.obterPorId(3L))
			.thenReturn(null);
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/metas/{id}", 3L)
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());			
	}
	
	@Test
	public void deveRetornarNaoEncontrado_QuandoBuscarMetas() {
				
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/metas/{id}",-1L)
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());	
		
		verify(this.metaService,never()).obterPorId(-1L);
	}

}

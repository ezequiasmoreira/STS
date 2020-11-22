package com.ezequias.apiestudo.domain.enums;

public enum Cargo {

	VENDEDOR(1,"Vendedor"),
	REPRESENTANTE(2,"Representante");
	
	private int cod;
	private String descricao;
	
	private Cargo(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static Cargo toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		for(Cargo x : Cargo.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}		
		}
		throw new IllegalArgumentException("Id inválido " + cod);
	}


}

package model.bo;

import annotations.Id;

public class Bairro {

        @Id
	private Long id;
        
	private String descricao;
	
	public Bairro() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long idBairro) {
		this.id = idBairro;
	}
	
	public String getDescricao() {
		return descricao;
	}
	

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

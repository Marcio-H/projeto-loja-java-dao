package model.bo;

public class Bairro {

	private Long id;
	private String descricao;
	
	public Bairro() {
	}
	
	public Long get() {
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

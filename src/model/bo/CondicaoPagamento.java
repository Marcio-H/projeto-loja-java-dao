package model.bo;

public class CondicaoPagamento {

	private int idCondicaoPagamento;
	private String descricaoCondicaoPagamento;
	private int numDiasAtePrimeiraParcela;
	private int numDiasEntreParcelas;
	
	public CondicaoPagamento() { }
	
	public int getIdCondicaoPagamento() {
		return idCondicaoPagamento;
	}
	
	public void setIdCondicaoPagamento(int idCondicaoPagamento) {
		this.idCondicaoPagamento = idCondicaoPagamento;
	}
	
	public String getDescricaoCondicaoPagamento() {
		return descricaoCondicaoPagamento;
	}
	
	public void setDescricaoCondicaoPagamento(String descricaoCondicaoPagamento) {
		this.descricaoCondicaoPagamento = descricaoCondicaoPagamento;
	}
	
	public int getNumDiasAtePrimeiraParcela() {
		return numDiasAtePrimeiraParcela;
	}
	
	public void setNumDiasAtePrimeiraParcela(int numDiasAtePrimeiraParcela) {
		this.numDiasAtePrimeiraParcela = numDiasAtePrimeiraParcela;
	}
	
	public int getNumDiasEntreParcelas() {
		return numDiasEntreParcelas;
	}
	
	public void setNumDiasEntreParcelas(int numDiasEntreParcelas) {
		this.numDiasEntreParcelas = numDiasEntreParcelas;
	}
}

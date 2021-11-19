package model.bo;

import java.time.LocalDateTime;

public class Compra {

	private int idCompra;
	private Fornecedor fornecedor;
	private CondicaoPagamento condicaoPagamento;
	private int numNFCompra;
	private String serieNFCompra;
	private LocalDateTime dtHrCompra;
	private float descontoCompra;
	private float valorTotalCompra;
	
	public Compra() { }

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	public int getNumNFCompra() {
		return numNFCompra;
	}

	public void setNumNFCompra(int numNFCompra) {
		this.numNFCompra = numNFCompra;
	}

	public String getSerieNFCompra() {
		return serieNFCompra;
	}

	public void setSerieNFCompra(String serieNFCompra) {
		this.serieNFCompra = serieNFCompra;
	}

	public LocalDateTime getDtHrCompra() {
		return dtHrCompra;
	}

	public void setDtHrCompra(LocalDateTime dtHrCompra) {
		this.dtHrCompra = dtHrCompra;
	}

	public float getDescontoCompra() {
		return descontoCompra;
	}

	public void setDescontoCompra(float descontoCompra) {
		this.descontoCompra = descontoCompra;
	}

	public float getValorTotalCompra() {
		return valorTotalCompra;
	}

	public void setValorTotalCompra(float valorTotalCompra) {
		this.valorTotalCompra = valorTotalCompra;
	}
}

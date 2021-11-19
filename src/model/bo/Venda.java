package model.bo;

import java.time.LocalDate;

public class Venda {

	private int idVenda;
	private String serieVenda;
	private LocalDate dtVenda;
	private String hrVenda;
	private float valDescontoVenda;
	private float valTotalVenda;
	private Cliente cliente;
	private CondicaoPagamento condicaoPagamento;
	private int diaVencimentoParcela;
	private Vendedor vendedor;
	
	public Venda() { }

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public String getSerieVenda() {
		return serieVenda;
	}

	public void setSerieVenda(String serieVenda) {
		this.serieVenda = serieVenda;
	}

	public LocalDate getDtVenda() {
		return dtVenda;
	}

	public void setDtVenda(LocalDate dtVenda) {
		this.dtVenda = dtVenda;
	}

	public String getHrVenda() {
		return hrVenda;
	}

	public void setHrVenda(String hrVenda) {
		this.hrVenda = hrVenda;
	}

	public float getValDescontoVenda() {
		return valDescontoVenda;
	}

	public void setValDescontoVenda(float valDescontoVenda) {
		this.valDescontoVenda = valDescontoVenda;
	}

	public float getValTotalVenda() {
		return valTotalVenda;
	}

	public void setValTotalVenda(float valTotalVenda) {
		this.valTotalVenda = valTotalVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	public int getDiaVencimentoParcela() {
		return diaVencimentoParcela;
	}

	public void setDiaVencimentoParcela(int diaVencimentoParcela) {
		this.diaVencimentoParcela = diaVencimentoParcela;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
}

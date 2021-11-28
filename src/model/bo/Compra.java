package model.bo;

import java.time.LocalDateTime;

public class Compra {

    private Long id;
    private Fornecedor fornecedor;
    private CondicaoPagamento condicaoPagamento;
    private int numeroNotaFiscal;
    private String serieNotaFiscal;
    private LocalDateTime criadoNo;
    private float desconto;
    private float total;

    public Compra() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getNumeroNotaFiscal() {
        return numeroNotaFiscal;
    }

    public void setNumeroNotaFiscal(int numeroNotaFiscal) {
        this.numeroNotaFiscal = numeroNotaFiscal;
    }

    public String getSerieNotaFiscal() {
        return serieNotaFiscal;
    }

    public void setSerieNotaFiscal(String serieNotaFiscal) {
        this.serieNotaFiscal = serieNotaFiscal;
    }

    public LocalDateTime getCriadoNo() {
        return criadoNo;
    }

    public void setCriadoNo(LocalDateTime criadoNo) {
        this.criadoNo = criadoNo;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}

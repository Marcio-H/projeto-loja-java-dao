package model.bo;

import annotations.Foreign;
import annotations.Id;
import java.time.LocalDateTime;

public class Venda {
    
    @Id
    private Long id;
    private String serie;
    private LocalDateTime criadoNo;
    private float desconto;
    private float total;

    @Foreign
    private Cliente cliente;
    @Foreign
    private CondicaoPagamento condicaoPagamento;
    private int diaVencimentoParcela;

    @Foreign
    private Vendedor vendedor;

    public Venda() {
      this.cliente = new Cliente();
      this.condicaoPagamento = new CondicaoPagamento();
      this.vendedor = new Vendedor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
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

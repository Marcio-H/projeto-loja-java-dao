package model.bo;

import annotations.Id;

public class CondicaoPagamento {

    @Id
    private Long id;
    
    private String descricao;
    
    private int numeroDiasAtePrimeiraParcela;
    
    private int numeroDiasEntreParcelas;

    public CondicaoPagamento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumeroDiasAtePrimeiraParcela() {
        return numeroDiasAtePrimeiraParcela;
    }

    public void setNumeroDiasAtePrimeiraParcela(int numeroDiasAtePrimeiraParcela) {
        this.numeroDiasAtePrimeiraParcela = numeroDiasAtePrimeiraParcela;
    }

    public int getNumeroDiasEntreParcelas() {
        return numeroDiasEntreParcelas;
    }

    public void setNumeroDiasEntreParcelas(int numeroDiasEntreParcelas) {
        this.numeroDiasEntreParcelas = numeroDiasEntreParcelas;
    }
}

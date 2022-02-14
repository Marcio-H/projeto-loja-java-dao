package model.bo;

import annotations.Foreign;
import annotations.Id;

public class Produto {

    @Id
    private Long id;
    
    private String descricao;
    
    private float valor;
    
    @Foreign
    private Marca marca;
    
    @Foreign
    private Tamanho tamanho;
    
    @Foreign
    private TipoProduto tipoProduto;

    public Produto() {
       this.marca = new Marca();
       this.tamanho = new Tamanho();
       this.tipoProduto = new TipoProduto();
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
}

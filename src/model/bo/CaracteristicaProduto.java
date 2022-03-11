package model.bo;

import annotations.Foreign;
import annotations.Id;

public class CaracteristicaProduto {

    @Id
    private Long id;
    
    @Foreign
    private Produto produto;
    
    @Foreign
    private Cor cor;
    
    private String tamanho;
    
    private String barra;
    
    private int estoque;

    public CaracteristicaProduto() {
        produto =  new Produto();
        cor = new Cor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getBarra() {
        return barra;
    }

    public void setBarra(String barra) {
        this.barra = barra;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}

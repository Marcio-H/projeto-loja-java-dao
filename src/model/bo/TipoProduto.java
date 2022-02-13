package model.bo;

import annotations.Id;

public class TipoProduto {
    
    @Id
    private Long id;

    private String descricao;

    public TipoProduto() {
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
}

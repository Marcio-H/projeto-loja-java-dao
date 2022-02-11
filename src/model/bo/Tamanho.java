package model.bo;

import annotations.Id;

public class Tamanho {
    
    @Id    
    private Long id;

    private String descricao;

    public Tamanho() {
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

package model.bo;

public class Marca {

    private Long id;
    private String descricao;

    public Marca() {
    }

    public Long getIdMarca() {
        return id;
    }

    public void setIdMarca(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

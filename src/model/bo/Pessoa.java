package model.bo;

import annotations.Foreign;

public abstract class Pessoa {
    
    private String nome;
    private String email;
    private String complementoEndereco;
    
    @Foreign
    private Endereco endereco;

    public Pessoa() {}
    
    public Pessoa(String nome, String email, String complementoEndereco, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.complementoEndereco = complementoEndereco;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}

package model.bo;

import annotations.Foreign;
import annotations.Id;

public class Fornecedor {

    @Id
    private Long id;

    private String razaoSocial;
    
    private String cnpj;
    
    private String inscricaoEstadual;
    
    private String nome;
    
    private String email;
    
    private String complementoEndereco;
    
    @Foreign
    private Endereco endereco;

    public Fornecedor() {
        endereco = new Endereco();
    }

    public Fornecedor(String razaoSocial, String cnpj, String inscricaoEstadual, String nome, String email, String complementoEndereco, Endereco endereco) {
        this.nome = nome;
        this.email = nome;
        this.complementoEndereco = complementoEndereco;
        this.endereco = endereco;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Fornecedor(Long id, String razaoSocial, String cnpj, String inscricaoEstadual, String nome, String email, String complementoEndereco, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.complementoEndereco = complementoEndereco;
        this.endereco =  endereco;
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
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

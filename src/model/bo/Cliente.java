package model.bo;

import annotations.Foreign;
import annotations.Id;
import java.sql.Date;

public class Cliente {

    @Id
    private Long id;
    
    private Date dataNascimento;
    
    private String cpf;
    
    private String rg;
    
    private String nome;
    
    private String email;
    
    private String complementoEndereco;
    
    @Foreign
    private Endereco endereco;

    public Cliente() {
      this.endereco = new Endereco();
    }

    public Cliente(Date dataNascimento, String cpf, String rg, String nome, String email, String complementoEndereco, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.complementoEndereco = complementoEndereco;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

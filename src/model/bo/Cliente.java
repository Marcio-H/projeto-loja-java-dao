package model.bo;

import java.time.LocalDate;

public class Cliente extends Pessoa {

    private Long id;
    private LocalDate dataNascimento;
    private String cpf;
    private String rg;
    private String fone;
    private String fone2;

    public Cliente() {
    }

    public Cliente(LocalDate dataNascimento, String cpf, String rg, String fone, String fone2, String nome, String email, String complementoEndereco, Endereco endereco) {
        super(nome, email, complementoEndereco, endereco);
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.fone = fone;
        this.fone2 = fone2;
    }

    public Cliente(Long id, LocalDate dataNascimento, String cpf, String rg, String fone, String fone2, String nome, String email, String complementoEndereco, Endereco endereco) {
        super(nome, email, complementoEndereco, endereco);
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.fone = fone;
        this.fone2 = fone2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDatatNascimento() {
        return dataNascimento;
    }

    public void setDatatNascimento(LocalDate dataNascimento) {
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

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getFone2() {
        return fone2;
    }

    public void setFone2(String fone2) {
        this.fone2 = fone2;
    }
}

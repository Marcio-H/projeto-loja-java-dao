package model.bo;

import annotations.Id;
import java.time.LocalDate;

public class Cliente extends Pessoa {

    @Id
    private Long id;
    private LocalDate dataNascimento;
    private String cpf;
    private String rg;

    public Cliente() {
    }

    public Cliente(LocalDate dataNascimento, String cpf, String rg, String nome, String email, String complementoEndereco, Endereco endereco) {
        super(nome, email, complementoEndereco, endereco);
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
    }

    public Cliente(Long id, LocalDate dataNascimento, String cpf, String rg, String nome, String email, String complementoEndereco, Endereco endereco) {
        super(nome, email, complementoEndereco, endereco);
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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
}

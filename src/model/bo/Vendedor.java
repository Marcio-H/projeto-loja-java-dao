package model.bo;

import annotations.Foreign;
import annotations.Id;
import model.bo.Endereco;

public class Vendedor {

    @Id
    private Long id;
    private String cpf;
    private float percentagemComissaoVenda;
    private float percentagemComissaoRecebimento;
    private String nome;
    private String email;
    private String complementoEndereco;
    @Foreign
    private Endereco endereco;

    public Vendedor() {
       this.endereco = new Endereco();
    }

    public Vendedor(String cpf, float percentagemComissaoVenda, float percentagemComissaoRecebimento, String nome, String email, String complementoEndereco, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.complementoEndereco = complementoEndereco;
        this.cpf = cpf;
        this.percentagemComissaoVenda = percentagemComissaoVenda;
        this.percentagemComissaoRecebimento = percentagemComissaoRecebimento;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public float getPercentagemComissaoVenda() {
        return percentagemComissaoVenda;
    }

    public void setPercentagemComissaoVenda(float percentagemComissaoVenda) {
        this.percentagemComissaoVenda = percentagemComissaoVenda;
    }

    public float getPercentagemComissaoRecebimento() {
        return percentagemComissaoRecebimento;
    }

    public void setPercentagemComissaoRecebimento(float percentagemComissaoRecebimento) {
        this.percentagemComissaoRecebimento = percentagemComissaoRecebimento;
    }
}

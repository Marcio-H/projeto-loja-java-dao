package model.bo;

import annotations.Id;

public class Vendedor extends Pessoa {

    @Id
    private Long id;
    private String cpf;
    private float percentagemComissaoVenda;
    private float percentagemComissaoRecebimento;

    public Vendedor() {
    }

    public Vendedor(String cpf, float percentagemComissaoVenda, float percentagemComissaoRecebimento, String nome, String email, String complementoEndereco, Endereco endereco) {
        super(nome, email, complementoEndereco, endereco);
        this.cpf = cpf;
        this.percentagemComissaoVenda = percentagemComissaoVenda;
        this.percentagemComissaoRecebimento = percentagemComissaoRecebimento;
    }

    public Vendedor(Long id, String cpf, float percentagemComissaoVenda, float percentagemComissaoRecebimento, String nome, String email, String complementoEndereco, Endereco endereco) {
        super(nome, email, complementoEndereco, endereco);
        this.id = id;
        this.cpf = cpf;
        this.percentagemComissaoVenda = percentagemComissaoVenda;
        this.percentagemComissaoRecebimento = percentagemComissaoRecebimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

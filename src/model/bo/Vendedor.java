package model.bo;

public class Vendedor extends Pessoa {

    private Long id;
    private String cpf;
    private String fone;
    private String fone2;
    private float percentagemComissaoVenda;
    private float percentagemComissaoRecebimento;

    public Vendedor() {
    }

    public Vendedor(String cpf, String fone, String fone2, float percentagemComissaoVenda, float percentagemComissaoRecebimento, String nome, String email, String complementoEndereco, Endereco endereco) {
        super(nome, email, complementoEndereco, endereco);
        this.cpf = cpf;
        this.fone = fone;
        this.fone2 = fone2;
        this.percentagemComissaoVenda = percentagemComissaoVenda;
        this.percentagemComissaoRecebimento = percentagemComissaoRecebimento;
    }

    public Vendedor(Long id, String cpf, String fone, String fone2, float percentagemComissaoVenda, float percentagemComissaoRecebimento, String nome, String email, String complementoEndereco, Endereco endereco) {
        super(nome, email, complementoEndereco, endereco);
        this.id = id;
        this.cpf = cpf;
        this.fone = fone;
        this.fone2 = fone2;
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

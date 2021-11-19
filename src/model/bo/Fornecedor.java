package model.bo;

public class Fornecedor extends Pessoa {

    private Long id;
    private String razaoSocial;
    private String cnpj;
    private String inscricaoEstadual;

    public Fornecedor() {
    }

    public Fornecedor(String razaoSocial, String cnpj, String inscricaoEstadual, String nome, String email, String complementoEndereco, Endereco endereco) {
        super(nome, email, complementoEndereco, endereco);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Fornecedor(Long id, String razaoSocial, String cnpj, String inscricaoEstadual, String nome, String email, String complementoEndereco, Endereco endereco) {
        super(nome, email, complementoEndereco, endereco);
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
}

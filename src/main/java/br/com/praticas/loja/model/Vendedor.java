package br.com.praticas.loja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vendedor {

    @Id
    private Long id;

    @Column
    private String cpf;

    @Column
    private float percentagemComissaoVenda;

    @Column
    private float percentagemComissaoRecebimento;
    
    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String complementoEndereco;

    @ManyToOne
    private Endereco endereco;
}

package domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Fornecedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String razaoSocial;

    @Column
    private String cnpj;

    @Column
    private String inscricaoEstadual;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String complementoEndereco;
    
    @ManyToOne
    private Endereco endereco;
    
    @OneToMany
    private List<TelefoneFornecedor> telefones;
}

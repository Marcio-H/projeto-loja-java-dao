package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

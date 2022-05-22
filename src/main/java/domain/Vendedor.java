package domain;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String cpf;

    @Column(name = "percentagem_comissao_venda")
    private float percentagemComissaoVenda;

    @Column(name = "percentagem_comissao_recebimento")
    private float percentagemComissaoRecebimento;
    
    @Column
    private String nome;

    @Column
    private String email;

    @Column(name = "complemento_endereco")
    private String complementoEndereco;

    @ManyToOne
    private Endereco endereco;

    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.PERSIST)
    private List<TelefoneVendedor> telefones;

    public List<TelefoneVendedor> getTelefones() {
    	if (isNull(telefones)) {
    		telefones = new ArrayList<>();
    	}
    	return telefones;
    }
}

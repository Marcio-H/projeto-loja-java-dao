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
public class Produto {
    
    @Id
    private Long id;

    @Column    
    private String descricao;
    
    @Column
    private float valor;
    
    @ManyToOne
    private Marca marca;
    
    @ManyToOne  
    private Tamanho tamanho;
    
    @ManyToOne
    private TipoProduto tipoProduto;
}

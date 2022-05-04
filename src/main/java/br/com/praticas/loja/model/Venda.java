package br.com.praticas.loja.model;

import java.math.BigDecimal;
import java.sql.Date;

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
public class Venda {
    
    @Id
    private Long id;

    @Column
    private String serie;

    @Column
    private Date criadoNo;

    @Column
    private BigDecimal desconto;

    @Column
    private BigDecimal total;

    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private CondicaoPagamento condicaoPagamento;

    @Column
    private Integer diaVencimentoParcela;

    @ManyToOne
    private Vendedor vendedor;
}

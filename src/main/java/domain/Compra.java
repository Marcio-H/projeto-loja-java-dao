package domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Fornecedor fornecedor;

    @ManyToOne
    private CondicaoPagamento condicaoPagamento;

    @Column
    private Integer numeroNotaFiscal;

    @Column
    private String serieNotaFiscal;

    @Column
    private LocalDateTime criadoNo;

    @Column
    private BigDecimal desconto;

    @Column
    private BigDecimal total;
}

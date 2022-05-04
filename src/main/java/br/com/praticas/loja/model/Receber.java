package br.com.praticas.loja.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class Receber {

    @Id
    private Long id;

    @ManyToOne
    private Venda venda;

    @Column
    private LocalDateTime dtHrEmissaoRec;

    @Column
    private BigDecimal valEmissaoRec;

    @Column
    private LocalDate dtVencimentoRec;

    @Column
    private LocalDate dtPgtoRec;

    @Column
    private BigDecimal acrescimoRec;

    @Column
    private BigDecimal descontoRec;

    @Column
    private BigDecimal valPagoRec;

    @Column
    private String statusRec;
}

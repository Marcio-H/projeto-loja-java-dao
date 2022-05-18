package domain;

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
public class Pagar {

	@Id
	private Long id;

	@ManyToOne
	private Compra compra;

	@Column
	private LocalDateTime dtHrEmissaoPagar;

	@Column
	private LocalDate dtVencimentoPagar;

	@Column
	private BigDecimal valEmitidoPagar;

	@Column
	private BigDecimal acrescimoPagar;

	@Column
	private BigDecimal descontoPagar;

	@Column
	private LocalDateTime dtHrPgtoPagar;

	@Column
	private BigDecimal valPagoPagar;

	@Column
	private String statusPagar;
}

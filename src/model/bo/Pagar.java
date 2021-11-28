package model.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pagar {

	private Long id;
	private Compra compra;
	private LocalDateTime dtHrEmissaoPagar;
	private LocalDate dtVencimentoPagar;
	private float valEmitidoPagar;
	private float acrescimoPagar;
	private float descontoPagar;
	private LocalDateTime dtHrPgtoPagar;
	private float valPagoPagar;
	private String statusPagar;
	
	public Pagar() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public LocalDateTime getDtHrEmissaoPagar() {
		return dtHrEmissaoPagar;
	}

	public void setDtHrEmissaoPagar(LocalDateTime dtHrEmissaoPagar) {
		this.dtHrEmissaoPagar = dtHrEmissaoPagar;
	}

	public LocalDate getDtVencimentoPagar() {
		return dtVencimentoPagar;
	}

	public void setDtVencimentoPagar(LocalDate dtVencimentoPagar) {
		this.dtVencimentoPagar = dtVencimentoPagar;
	}

	public float getValEmitidoPagar() {
		return valEmitidoPagar;
	}

	public void setValEmitidoPagar(float valEmitidoPagar) {
		this.valEmitidoPagar = valEmitidoPagar;
	}

	public float getAcrescimoPagar() {
		return acrescimoPagar;
	}

	public void setAcrescimoPagar(float acrescimoPagar) {
		this.acrescimoPagar = acrescimoPagar;
	}

	public float getDescontoPagar() {
		return descontoPagar;
	}

	public void setDescontoPagar(float descontoPagar) {
		this.descontoPagar = descontoPagar;
	}

	public LocalDateTime getDtHrPgtoPagar() {
		return dtHrPgtoPagar;
	}

	public void setDtHrPgtoPagar(LocalDateTime dtHrPgtoPagar) {
		this.dtHrPgtoPagar = dtHrPgtoPagar;
	}

	public float getValPagoPagar() {
		return valPagoPagar;
	}

	public void setValPagoPagar(float valPagoPagar) {
		this.valPagoPagar = valPagoPagar;
	}

	public String getStatusPagar() {
		return statusPagar;
	}

	public void setStatusPagar(String statusPagar) {
		this.statusPagar = statusPagar;
	}
}

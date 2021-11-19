package model.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Receber {

	private int idReceber;
	private Venda venda;
	private LocalDateTime dtHrEmissaoRec;
	private float valEmissaoRec;
	private LocalDate dtVencimentoRec;
	private LocalDate dtPgtoRec;
	private float acrescimoRec;
	private float descontoRec;
	private float valPagoRec;
	private String statusRec;
	
	public Receber() { }

	public int getIdReceber() {
		return idReceber;
	}

	public void setIdReceber(int idReceber) {
		this.idReceber = idReceber;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public LocalDateTime getDtHrEmissaoRec() {
		return dtHrEmissaoRec;
	}

	public void setDtHrEmissaoRec(LocalDateTime dtHrEmissaoRec) {
		this.dtHrEmissaoRec = dtHrEmissaoRec;
	}

	public float getValEmissaoRec() {
		return valEmissaoRec;
	}

	public void setValEmissaoRec(float valEmissaoRec) {
		this.valEmissaoRec = valEmissaoRec;
	}

	public LocalDate getDtVencimentoRec() {
		return dtVencimentoRec;
	}

	public void setDtVencimentoRec(LocalDate dtVencimentoRec) {
		this.dtVencimentoRec = dtVencimentoRec;
	}

	public LocalDate getDtPgtoRec() {
		return dtPgtoRec;
	}

	public void setDtPgtoRec(LocalDate dtPgtoRec) {
		this.dtPgtoRec = dtPgtoRec;
	}

	public float getAcrescimoRec() {
		return acrescimoRec;
	}

	public void setAcrescimoRec(float acrescimoRec) {
		this.acrescimoRec = acrescimoRec;
	}

	public float getDescontoRec() {
		return descontoRec;
	}

	public void setDescontoRec(float descontoRec) {
		this.descontoRec = descontoRec;
	}

	public float getValPagoRec() {
		return valPagoRec;
	}

	public void setValPagoRec(float valPagoRec) {
		this.valPagoRec = valPagoRec;
	}

	public String getStatusRec() {
		return statusRec;
	}

	public void setStatusRec(String statusRec) {
		this.statusRec = statusRec;
	}
}

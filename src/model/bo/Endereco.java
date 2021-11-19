package model.bo;

public class Endereco {

	private int idCep;
	private String cepCep;
	private String logradouroCep;
	private Cidade cidade;
	private Bairro bairro;
	
	public Endereco() {	}

	public int getIdCep() {
		return idCep;
	}

	public void setIdCep(int idCep) {
		this.idCep = idCep;
	}

	public String getCepCep() {
		return cepCep;
	}

	public void setCepCep(String cepCep) {
		this.cepCep = cepCep;
	}

	public String getLogradouroCep() {
		return logradouroCep;
	}

	public void setLogradouroCep(String logradouroCep) {
		this.logradouroCep = logradouroCep;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
}

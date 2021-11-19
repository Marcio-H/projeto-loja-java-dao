package model.bo;

public class FoneFornecedor {

	private String foneFornecedor;
	private Fornecedor fornecedor;
	
	public FoneFornecedor() { }
	
	public String getFoneFornecedor() {
		return foneFornecedor;
	}
	
	public void setFoneFornecedor(String foneFornecedor) {
		this.foneFornecedor = foneFornecedor;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}

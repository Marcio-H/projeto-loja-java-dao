package model.bo;

public class ItensVenda {

	private int idItensVenda;
	private Venda venda;
	private CaracteristicaProduto caracteristicaProduto;
	private float valUnitarioProduto;
	private float qtdProduto;
	
	public ItensVenda() { }

	public int getIdItensVenda() {
		return idItensVenda;
	}

	public void setIdItensVenda(int idItensVenda) {
		this.idItensVenda = idItensVenda;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public CaracteristicaProduto getCaracteristicaProduto() {
		return caracteristicaProduto;
	}

	public void setCaracteristicaProduto(CaracteristicaProduto caracteristicaProduto) {
		this.caracteristicaProduto = caracteristicaProduto;
	}

	public float getValUnitarioProduto() {
		return valUnitarioProduto;
	}

	public void setValUnitarioProduto(float valUnitarioProduto) {
		this.valUnitarioProduto = valUnitarioProduto;
	}

	public float getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(float qtdProduto) {
		this.qtdProduto = qtdProduto;
	}
}

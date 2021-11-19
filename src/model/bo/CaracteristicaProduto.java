package model.bo;

public class CaracteristicaProduto {

	private int idCaracteristicaProduto;
	private Produto produto;
	private Cor cor;
        private String tamanhoProduto;
        private String barraProduto;
        private int qtdEstoqueProduto;
	
	public CaracteristicaProduto() { }

	public int getIdCaracteristicaProduto() {
		return idCaracteristicaProduto;
	}

	public void setIdCaracteristicaProduto(int idCaracteristicaProduto) {
		this.idCaracteristicaProduto = idCaracteristicaProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}
}

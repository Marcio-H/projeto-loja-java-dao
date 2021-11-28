package model.bo;

public class ItensVenda {

    private Long id;
    private Venda venda;
    private CaracteristicaProduto caracteristicaProduto;
    private float valor;
    private Long quantidade;

    public ItensVenda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}

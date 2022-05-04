package model.DAO.objects;

import java.sql.SQLException;
import java.util.List;
import model.DAO.BaseDAO;
import model.DAO.InterfaceDAO;
import model.bo.CaracteristicaProduto;

public class CaracteristicaProdutoDAO extends BaseDAO<CaracteristicaProduto> implements InterfaceDAO<CaracteristicaProduto> {
    
    private static final ProdutoDAO produtoDAO = new ProdutoDAO();
    private static final CorDAO corDAO = new CorDAO();

    @Override
    public CaracteristicaProduto create(CaracteristicaProduto objeto) {
        return abstractCreate(objeto);
    }

    @Override
    public List<CaracteristicaProduto> read() {
        return abstractRead(CaracteristicaProduto.class);
    }

    @Override
    public CaracteristicaProduto read(Long codigo) {
        return (CaracteristicaProduto) abstractReadById(codigo, CaracteristicaProduto.class);
    }

    @Override
    public CaracteristicaProduto update(CaracteristicaProduto objeto) {
        return abstractUpdate(objeto);
    }

    @Override
    public void delete(CaracteristicaProduto objeto) {
        abstractDelete(CaracteristicaProduto.class, objeto.getId());
    }

    public CaracteristicaProduto findByBarra(String barra) {
        String sql = "SELECT id, tamanho, barra, estoque, cor_id, produto_id FROM caracteristica_produto WHERE barra = ?";

        openConnection();
        try {
            prepareStatement(sql);
            preparedStatement.setString(1, barra);
            resultSet();
            if (resultSet.next()) {
                CaracteristicaProduto objeto = new CaracteristicaProduto();
                
                objeto.setId(resultSet.getLong(1));
                objeto.setTamanho(resultSet.getString(2));
                objeto.setBarra(resultSet.getString(3));
                objeto.setEstoque(resultSet.getInt(4));
                
                Long cor_id = resultSet.getLong(5);
                Long produto_id = resultSet.getLong(6);
                
                close();
                
                objeto.setProduto(produtoDAO.read(produto_id));
                objeto.setCor(corDAO.read(cor_id));
                return objeto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return null;
    }
}

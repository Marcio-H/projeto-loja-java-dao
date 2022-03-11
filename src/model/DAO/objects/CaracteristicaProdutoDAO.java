package model.DAO.objects;

import java.util.List;
import model.DAO.BaseDAO;
import model.DAO.InterfaceDAO;
import model.bo.CaracteristicaProduto;

public class CaracteristicaProdutoDAO extends BaseDAO<CaracteristicaProduto> implements InterfaceDAO<CaracteristicaProduto>{

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
}

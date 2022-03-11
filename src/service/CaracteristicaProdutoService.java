package service;

import java.util.List;
import model.DAO.objects.CaracteristicaProdutoDAO;
import model.bo.CaracteristicaProduto;

public class CaracteristicaProdutoService {
    
    private CaracteristicaProdutoDAO caracteristicaProdutoDAO;

    public CaracteristicaProdutoService() {
        caracteristicaProdutoDAO = new CaracteristicaProdutoDAO();
    }

    public void createOrUpdate(CaracteristicaProduto objeto) {
        if (objeto.getId() == null) {
            caracteristicaProdutoDAO.create(objeto);
        } else {
            caracteristicaProdutoDAO.update(objeto);
        }
    }
    
    public List<CaracteristicaProduto> read() {
        return caracteristicaProdutoDAO.read();
    }
    
    public CaracteristicaProduto readById(Long id) {
        return caracteristicaProdutoDAO.read(id);
    }
}

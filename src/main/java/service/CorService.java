package service;

import java.util.List;

import dao.impl.CorDAO;
import domain.Cor;

public class CorService {

    private CorDAO corDAO;

    public CorService() {
        this.corDAO = new CorDAO();
    }

    public void createOrUpdate(Cor objeto) {
        if (objeto.getId() == null) {
            corDAO.create(objeto);
        } else {
            corDAO.update(objeto);
        }
    }

    public List<Cor> read() {
        return corDAO.read();
    }

    public Cor readById(Long id) {
        return corDAO.read(id);
    }
}

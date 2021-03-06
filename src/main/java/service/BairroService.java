package service;

import java.util.List;

import dao.impl.BairroDAO;
import domain.Bairro;

public class BairroService {

    private BairroDAO bairroDao;

    public BairroService() {
     bairroDao = new BairroDAO();
   }

    public void createOrUpdate(Bairro objeto) {
        if (objeto.getId() == null) {
            bairroDao.create(objeto);
        } else {
            bairroDao.update(objeto);
        }
    }
    
    public List<Bairro> read() {
        return bairroDao.read();
    }
    
    public Bairro readById(Long id) {
        return bairroDao.read(id);
    }
}

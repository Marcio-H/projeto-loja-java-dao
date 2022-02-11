package service;

import java.util.List;
import model.bo.Bairro;
import model.DAO.objects.BairroDAO;

public class BairroService {
    private BairroDAO bairroDao; 

    public BairroService() {
     this.bairroDao = new BairroDAO();
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

package service;

import java.util.List;
import model.bo.Cidade;
import model.dao.objects.CidadeDAO;

public class CidadeService {

    private CidadeDAO cidadeDAO;
    
    public CidadeService() {
        cidadeDAO = new CidadeDAO();
    }

    public void createOrUpdate(Cidade objeto) {
        if (objeto.getId() == null) {
            cidadeDAO.create(objeto);
        } else {
            cidadeDAO.update(objeto);
        }
    }
    
    public List<Cidade> read() {
        return cidadeDAO.read();
    }
    
    public Cidade readById(Long id) {
        return cidadeDAO.read(id);
    }
}

package service;

import java.util.List;
import model.bo.Marca;
import model.DAO.objects.MarcaDAO;

public class MarcaService {
    private MarcaDAO marcaDao; 

    public MarcaService() {
     this.marcaDao = new MarcaDAO();
   }

    public void createOrUpdate(Marca objeto) {
        if (objeto.getId() == null) {
            marcaDao.create(objeto);
        } else {
            marcaDao.update(objeto);
        }
    }
    
    public List<Marca> read() {
        return marcaDao.read();
    }
    
    public Marca readById(Long id) {
        return marcaDao.read(id);
    }
}

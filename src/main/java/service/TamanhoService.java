package service;

import java.util.List;

import dao.impl.TamanhoDAO;
import domain.Tamanho;

public class TamanhoService {
   private TamanhoDAO tamanhoDao;

   public TamanhoService() {
     this.tamanhoDao = new TamanhoDAO();
   }

    public void createOrUpdate(Tamanho objeto) {
        if (objeto.getId() == null) {
            tamanhoDao.create(objeto);
        } else {
            tamanhoDao.update(objeto);
        }
    }
    
    public List<Tamanho> read() {
        return tamanhoDao.read();
    }
    
    public Tamanho readById(Long id) {
        return tamanhoDao.read(id);
    }
}

package service;

import java.util.List;
import model.DAO.objects.TelefoneDAO;
import model.bo.Telefone;

public class TelefoneService {
   
    private TelefoneDAO telefoneDAO;

    public TelefoneService() {
        telefoneDAO = new TelefoneDAO();
    }
    
    public void createOrUpdate(Telefone objeto) {
        if (objeto.getId() == null) {
            telefoneDAO.create(objeto);
        } else {
            telefoneDAO.update(objeto);
        }
    }
    
    public List<Telefone> read() {
        return telefoneDAO.read();
    }
    
    public Telefone readById(Long id) {
        return telefoneDAO.read(id);
    }
}
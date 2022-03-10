package service;

import java.util.List;
import model.bo.Venda;
import model.DAO.objects.VendaDAO;

public class VendaService {
   private VendaDAO vendaDAO;

   public VendaService() {
     this.vendaDAO = new VendaDAO();
   }

    public void createOrUpdate(Venda objeto) {
        if (objeto.getId() == null) {
            vendaDAO.create(objeto);
        } else {
            vendaDAO.update(objeto);
        }
    }
    
    public List<Venda> read() {
        return vendaDAO.read();
    }
    
    public Venda readById(Long id) {
        return vendaDAO.read(id);
    }
}


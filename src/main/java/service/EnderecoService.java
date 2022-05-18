package service;

import java.util.List;

import dao.impl.EnderecoDAO;
import domain.Endereco;

public class EnderecoService {
   private EnderecoDAO enderecoDAO;

   public EnderecoService() {
     this.enderecoDAO = new EnderecoDAO();
   }

    public void createOrUpdate(Endereco objeto) {
        if (objeto.getId() == null) {
            enderecoDAO.create(objeto);
        } else {
            enderecoDAO.update(objeto);
        }
    }
    
    public List<Endereco> read() {
        return enderecoDAO.read();
    }
    
    public Endereco readById(Long id) {
        return enderecoDAO.read(id);
    }
}


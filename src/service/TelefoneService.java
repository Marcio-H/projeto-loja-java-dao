package service;

import java.util.List;
import model.DAO.objects.TelefoneDAO;
import model.bo.Cliente;
import model.bo.Fornecedor;
import model.bo.Vendedor;
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
    
    public List<Telefone> findByFornecedor(Fornecedor fornecedor) {
        return telefoneDAO.findByFornecedor(fornecedor);
    }
    
    public List<Telefone> findByVendedor(Vendedor vendedor) {
        return telefoneDAO.findByVendedor(vendedor);
    }
    
    public List<Telefone> findByCliente(Cliente cliente) {
        return telefoneDAO.findByCliente(cliente);
    }
    
    public void delete(Telefone deletedTelefone) {
        if (deletedTelefone.getId() !=  null) {
            telefoneDAO.delete(deletedTelefone);
        }
    }
}

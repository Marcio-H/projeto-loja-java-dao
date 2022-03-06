package service;

import java.util.List;
import model.DAO.objects.ClienteDAO;
import model.bo.Cliente;

public class ClienteService {
    
    private ClienteDAO clienteDAO;

    public ClienteService() {
        clienteDAO = new ClienteDAO();
    }
    
    public Cliente createOrUpdate(Cliente objeto) {
        if (objeto.getId() == null) {
            return clienteDAO.create(objeto);
        } else {
            return clienteDAO.update(objeto);
        }
    }
    
    public List<Cliente> read() {
        return clienteDAO.read();
    }
    
    public Cliente readById(Long codigo) {
        return clienteDAO.read(codigo);
    }
}

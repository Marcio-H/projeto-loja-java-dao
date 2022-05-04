package model.DAO.objects;

import java.util.List;
import model.DAO.BaseDAO;
import model.bo.Cliente;
import model.DAO.InterfaceDAO;

public class ClienteDAO extends BaseDAO<Cliente> implements InterfaceDAO<Cliente>{

    @Override
    public Cliente create(Cliente objeto) {
        return this.abstractCreate(objeto);
    }
    
    @Override
    public List<Cliente> read() {
        return abstractRead(Cliente.class);
    }

    @Override
    public Cliente read(Long codigo) {
        return (Cliente) abstractReadById(codigo, Cliente.class);
    }

    @Override
    public Cliente update(Cliente objeto) {
        return abstractUpdate(objeto);
    }

    @Override
    public void delete(Cliente objeto) {
        abstractDelete(Cliente.class, objeto.getId());
    }
}

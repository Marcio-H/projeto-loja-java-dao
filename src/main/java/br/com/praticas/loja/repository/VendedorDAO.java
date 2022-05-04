package model.DAO.objects;

import java.util.List;
import model.DAO.BaseDAO;
import model.bo.Vendedor;
import model.DAO.InterfaceDAO;

public class VendedorDAO extends BaseDAO<Vendedor> implements InterfaceDAO<Vendedor>{

    @Override
    public Vendedor create(Vendedor objeto) {
        return this.abstractCreate(objeto);
    }
    
    @Override
    public List<Vendedor> read() {
        return abstractRead(Vendedor.class);
    }

    @Override
    public Vendedor read(Long codigo) {
        return (Vendedor) abstractReadById(codigo, Vendedor.class);
    }

    @Override
    public Vendedor update(Vendedor objeto) {
        return abstractUpdate(objeto);
    }

    @Override
    public void delete(Vendedor objeto) {
        abstractDelete(Vendedor.class, objeto.getId());
    }
}
package model.DAO.objects;

import java.util.List;
import model.DAO.BaseDAO;
import model.bo.Fornecedor;
import model.DAO.InterfaceDAO;

public class FornecedorDAO extends BaseDAO<Fornecedor> implements InterfaceDAO<Fornecedor>{

    @Override
    public Fornecedor create(Fornecedor objeto) {
        return this.abstractCreate(objeto);
    }
    
    @Override
    public List<Fornecedor> read() {
        return abstractRead(Fornecedor.class);
    }

    @Override
    public Fornecedor read(Long codigo) {
        return (Fornecedor) abstractReadById(codigo, Fornecedor.class);
    }

    @Override
    public Fornecedor update(Fornecedor objeto) {
        return abstractUpdate(objeto);
    }

    @Override
    public void delete(Fornecedor objeto) {
        abstractDelete(Fornecedor.class, objeto.getId());
    }
}

package model.DAO.objects;

import java.util.List;
import model.DAO.BaseDAO;
import model.bo.Fornecedor;
import model.DAO.InterfaceDAO;

public class FornecedorDAO extends BaseDAO<Fornecedor> implements InterfaceDAO<Fornecedor>{

    @Override
    public void create(Fornecedor objeto) {
        this.abstractCreate(objeto);
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
    public void update(Fornecedor objeto) {
        abstractUpdate(objeto);
    }

    @Override
    public void delete(Fornecedor objeto) {
        abstractDelete(Fornecedor.class, objeto.getId());
    }
}

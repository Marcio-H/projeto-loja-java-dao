package model.DAO.objects;

import java.util.List;
import model.bo.Produto;
import model.DAO.BaseDAO;
import model.DAO.InterfaceDAO;

public class ProdutoDAO extends BaseDAO<Produto> implements InterfaceDAO<Produto>{
    
    public ProdutoDAO() {}

    @Override
    public Produto create(Produto objeto) {
        return abstractCreate(objeto);
    }

    @Override
    public List<Produto> read() {
        return abstractRead(Produto.class);
    }

    @Override
    public Produto read(Long codigo) {
        return (Produto) abstractReadById(codigo, Produto.class);
    }

    @Override
    public Produto update(Produto objeto) {
        return abstractUpdate(objeto);
    }

    @Override
    public void delete(Produto objeto) {
        abstractDelete(Produto.class, objeto.getId());
    }
}

package model.DAO.objects;

import java.util.List;
import model.bo.TipoProduto;
import model.DAO.BaseDAO;
import model.DAO.InterfaceDAO;

public class TipoProdutoDAO extends BaseDAO implements InterfaceDAO<TipoProduto>{

    @Override
    public void create(TipoProduto objeto) {
        this.abstractCreate(objeto);
    }

    @Override
    public List<TipoProduto> read() {
        return abstractRead(TipoProduto.class);
    }

    @Override
    public TipoProduto read(Long codigo) {
        return (TipoProduto) this.abstractReadById(codigo, TipoProduto.class);
    }

    @Override
    public void update(TipoProduto objeto) {
        abstractUpdate(objeto);
    }

    @Override
    public void delete(TipoProduto objeto) {
        abstractDelete(TipoProduto.class, objeto.getId());
    }
}


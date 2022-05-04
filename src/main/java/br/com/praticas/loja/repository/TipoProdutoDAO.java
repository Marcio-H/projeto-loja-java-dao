package model.DAO.objects;

import java.util.List;
import model.bo.TipoProduto;
import model.DAO.BaseDAO;
import model.DAO.InterfaceDAO;

public class TipoProdutoDAO extends BaseDAO<TipoProduto> implements InterfaceDAO<TipoProduto>{

    @Override
    public TipoProduto create(TipoProduto objeto) {
        return this.abstractCreate(objeto);
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
    public TipoProduto update(TipoProduto objeto) {
        return abstractUpdate(objeto);
    }

    @Override
    public void delete(TipoProduto objeto) {
        abstractDelete(TipoProduto.class, objeto.getId());
    }
}


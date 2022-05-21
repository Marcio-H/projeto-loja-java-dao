package model.DAO.objects;

import java.util.List;
import model.bo.Tamanho;
import model.DAO.BaseDAO;
import model.DAO.InterfaceDAO;

public class TamanhoDAO extends BaseDAO<Tamanho> implements InterfaceDAO<Tamanho>{

    @Override
    public Tamanho create(Tamanho objeto) {
        return this.abstractCreate(objeto);
    }

    @Override
    public List<Tamanho> read() {
        return abstractRead(Tamanho.class);
    }

    @Override
    public Tamanho read(Long codigo) {
        return (Tamanho) this.abstractReadById(codigo, Tamanho.class);
    }

    @Override
    public Tamanho update(Tamanho objeto) {
        return abstractUpdate(objeto);
    }

    @Override
    public void delete(Tamanho objeto) {
        abstractDelete(Tamanho.class, objeto.getId());
    }
}

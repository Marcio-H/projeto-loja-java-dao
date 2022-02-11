package model.DAO.objects;

import java.util.List;
import model.bo.Tamanho;
import model.DAO.BaseDAO;
import model.DAO.InterfaceDAO;

public class TamanhoDAO extends BaseDAO implements InterfaceDAO<Tamanho>{

    @Override
    public void create(Tamanho objeto) {
        this.abstractCreate(objeto);
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
    public void update(Tamanho objeto) {
        abstractUpdate(objeto);
    }

    @Override
    public void delete(Tamanho objeto) {
        abstractDelete(Tamanho.class, objeto.getId());
    }
}

package model.dao.objects;

import java.util.List;
import model.bo.Cidade;
import model.dao.BaseDAO;
import model.dao.InterfaceDAO;

public class CidadeDAO extends BaseDAO<Cidade> implements InterfaceDAO<Cidade>{

    @Override
    public void create(Cidade objeto) {
        this.abstractCreate(objeto);
    }

    @Override
    public List<Cidade> read() {
        return abstractRead(Cidade.class);
    }

    @Override
    public Cidade read(Long codigo) {
        return (Cidade) this.abstractReadById(codigo, Cidade.class);
    }

    @Override
    public void update(Cidade objeto) {
        abstractUpdate(objeto);
    }

    @Override
    public void delete(Cidade objeto) {
        abstractDelete(Cidade.class, objeto.getId());
    }
}

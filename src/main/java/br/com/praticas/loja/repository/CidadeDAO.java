package model.DAO.objects;

import java.util.List;
import model.bo.Cidade;
import model.DAO.BaseDAO;
import model.DAO.InterfaceDAO;

public class CidadeDAO extends BaseDAO<Cidade> implements InterfaceDAO<Cidade>{

    @Override
    public Cidade create(Cidade objeto) {
        return this.abstractCreate(objeto);
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
    public Cidade update(Cidade objeto) {
        return abstractUpdate(objeto);
    }

    @Override
    public void delete(Cidade objeto) {
        abstractDelete(Cidade.class, objeto.getId());
    }
}

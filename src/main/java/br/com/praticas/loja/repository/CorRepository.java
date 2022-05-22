package model.DAO.objects;

import java.util.List;
import model.bo.Cor;
import model.DAO.BaseDAO;
import model.DAO.InterfaceDAO;

public class CorDAO extends BaseDAO<Cor> implements InterfaceDAO<Cor>{

    @Override
    public Cor create(Cor objeto) {
        return this.abstractCreate(objeto);
    }

    @Override
    public List<Cor> read() {
        return abstractRead(Cor.class);
    }

    @Override
    public Cor read(Long codigo) {
        return (Cor) this.abstractReadById(codigo, Cor.class);
    }

    @Override
    public Cor update(Cor objeto) {
        return abstractUpdate(objeto);
    }

    @Override
    public void delete(Cor objeto) {
        abstractDelete(Cor.class, objeto.getId());
    }
}

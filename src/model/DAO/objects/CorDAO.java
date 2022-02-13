package model.DAO.objects;

import java.util.List;
import model.bo.Cor;
import model.DAO.BaseDAO;
import model.DAO.InterfaceDAO;

public class CorDAO extends BaseDAO implements InterfaceDAO<Cor>{

    @Override
    public void create(Cor objeto) {
        this.abstractCreate(objeto);
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
    public void update(Cor objeto) {
        abstractUpdate(objeto);
    }

    @Override
    public void delete(Cor objeto) {
        abstractDelete(Cor.class, objeto.getId());
    }
}

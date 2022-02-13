package model.DAO.objects;

import java.util.List;
import model.bo.Bairro;
import model.DAO.InterfaceDAO;
import model.DAO.BaseDAO;

public class BairroDAO extends BaseDAO<Bairro> implements InterfaceDAO<Bairro>{

    public BairroDAO() {}
    
    @Override
    public void create(Bairro objeto) {
        this.abstractCreate(objeto);
    }

    @Override
    public List<Bairro> read() {
        return abstractRead(Bairro.class);
    }

    @Override
    public Bairro read(Long codigo) {
        return (Bairro) abstractReadById(codigo, Bairro.class);
    }

    @Override
    public void update(Bairro objeto) {
        abstractUpdate(objeto);
    }

    @Override
    public void delete(Bairro objeto) {
        abstractDelete(Bairro.class, objeto.getId());
    }
}

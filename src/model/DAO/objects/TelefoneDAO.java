package model.DAO.objects;

import java.util.List;
import model.DAO.BaseDAO;
import model.DAO.InterfaceDAO;
import model.bo.Telefone;

public class TelefoneDAO extends BaseDAO<Telefone> implements InterfaceDAO<Telefone> {

    @Override
    public void create(Telefone objeto) {
        abstractCreate(objeto);
    }

    @Override
    public List<Telefone> read() {
        return abstractRead(Telefone.class);
    }

    @Override
    public Telefone read(Long codigo) {
        return (Telefone) abstractReadById(codigo, Telefone.class);
    }

    @Override
    public void update(Telefone objeto) {
        abstractUpdate(objeto);
    }

    @Override
    public void delete(Telefone objeto) {
        abstractDelete(Telefone.class, objeto.getId());
    }
}

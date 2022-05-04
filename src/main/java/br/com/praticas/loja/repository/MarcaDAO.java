package model.DAO.objects;

import java.util.List;
import model.bo.Marca;
import model.DAO.BaseDAO;
import model.DAO.InterfaceDAO;

public class MarcaDAO extends BaseDAO<Marca> implements InterfaceDAO<Marca>{

    @Override
    public Marca create(Marca objeto) {
        return this.abstractCreate(objeto);
    }

    @Override
    public List<Marca> read() {
        return abstractRead(Marca.class);
    }

    @Override
    public Marca read(Long codigo) {
        return (Marca) this.abstractReadById(codigo, Marca.class);
    }

    @Override
    public Marca update(Marca objeto) {
        return abstractUpdate(objeto);
    }

    @Override
    public void delete(Marca objeto) {
        abstractDelete(Marca.class, objeto.getId());
    }
}

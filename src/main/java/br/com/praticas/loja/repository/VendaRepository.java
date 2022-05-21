package model.DAO.objects;

import java.util.List;
import model.bo.Venda;
import model.DAO.BaseDAO;
import model.DAO.InterfaceDAO;

public class VendaDAO extends BaseDAO<Venda> implements InterfaceDAO<Venda>{
    
    public VendaDAO() {}

    @Override
    public Venda create(Venda objeto) {
        return abstractCreate(objeto);
    }

    @Override
    public List<Venda> read() {
        return abstractRead(Venda.class);
    }

    @Override
    public Venda read(Long codigo) {
        return (Venda) abstractReadById(codigo, Venda.class);
    }

    @Override
    public Venda update(Venda objeto) {
        return abstractUpdate(objeto);
    }

    @Override
    public void delete(Venda objeto) {
        abstractDelete(Venda.class, objeto.getId());
    }
}

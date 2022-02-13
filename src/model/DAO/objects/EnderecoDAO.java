package model.DAO.objects;

import java.util.List;
import model.bo.Endereco;
import model.DAO.BaseDAO;
import model.DAO.InterfaceDAO;

public class EnderecoDAO extends BaseDAO<Endereco> implements InterfaceDAO<Endereco>{
    
    public EnderecoDAO() {}

    @Override
    public Endereco create(Endereco objeto) {
        return abstractCreate(objeto);
    }

    @Override
    public List<Endereco> read() {
        return abstractRead(Endereco.class);
    }

    @Override
    public Endereco read(Long codigo) {
        return (Endereco) abstractReadById(codigo, Endereco.class);
    }

    @Override
    public Endereco update(Endereco objeto) {
        return abstractUpdate(objeto);
    }

    @Override
    public void delete(Endereco objeto) {
        abstractDelete(Endereco.class, objeto.getId());
    }
}

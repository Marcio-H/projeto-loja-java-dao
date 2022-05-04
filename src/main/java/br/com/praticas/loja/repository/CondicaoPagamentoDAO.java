package model.DAO.objects;

import java.util.List;
import model.DAO.BaseDAO;
import model.bo.CondicaoPagamento;
import model.DAO.InterfaceDAO;

public class CondicaoPagamentoDAO extends BaseDAO<CondicaoPagamento> implements InterfaceDAO<CondicaoPagamento> {

    @Override
    public CondicaoPagamento create(CondicaoPagamento objeto) {
        return abstractCreate(objeto);
    }

    @Override
    public List<CondicaoPagamento> read() {
        return abstractRead(CondicaoPagamento.class);
    }

    @Override
    public CondicaoPagamento read(Long codigo) {
        return (CondicaoPagamento) abstractReadById(codigo, CondicaoPagamento.class);
    }

    @Override
    public CondicaoPagamento update(CondicaoPagamento objeto) {
        return abstractUpdate(objeto);
    }

    @Override
    public void delete(CondicaoPagamento objeto) {
        abstractDelete(CondicaoPagamento.class, objeto.getId());
    }
}

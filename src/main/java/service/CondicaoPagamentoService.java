package service;

import java.util.List;

import dao.impl.CondicaoPagamentoDAO;
import domain.CondicaoPagamento;

public class CondicaoPagamentoService {
    
    private CondicaoPagamentoDAO condicaoPagamentoDAO;

    public CondicaoPagamentoService() {
        this.condicaoPagamentoDAO = new CondicaoPagamentoDAO();
    }
    
    public void createOrUpdate(CondicaoPagamento objeto) {
        if (objeto.getId() == null) {
            condicaoPagamentoDAO.create(objeto);
        } else {
            condicaoPagamentoDAO.update(objeto);
        }
    }
    
    public List<CondicaoPagamento> read() {
        return condicaoPagamentoDAO.read();
    }

    public CondicaoPagamento readById(Long id) {
        return condicaoPagamentoDAO.read(id);
    }
}

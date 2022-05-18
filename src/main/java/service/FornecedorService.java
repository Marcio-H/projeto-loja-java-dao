package service;

import java.util.List;

import dao.impl.FornecedorDAO;
import domain.Fornecedor;

public class FornecedorService {
    
    private FornecedorDAO fornecedorDAO;

    public FornecedorService() {
        fornecedorDAO = new FornecedorDAO();
    }
    
    public Fornecedor createOrUpdate(Fornecedor objeto) {
        if (objeto.getId() == null) {
            return fornecedorDAO.create(objeto);
        } else {
            return fornecedorDAO.update(objeto);
        }
    }
    
    public List<Fornecedor> read() {
        return fornecedorDAO.read();
    }
    
    public Fornecedor readById(Long codigo) {
        return fornecedorDAO.read(codigo);
    }
}

package service;

import model.DAO.objects.FornecedorDAO;

public class FornecedorService {
    
    private FornecedorDAO fornecedorDAO;

    public FornecedorService() {
        fornecedorDAO = new FornecedorDAO();
    }
}

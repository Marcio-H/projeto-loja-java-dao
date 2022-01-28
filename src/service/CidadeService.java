package service;

import model.bo.Cidade;
import model.dao.objects.CidadeDAO;

public class CidadeService {
    
    public  void salvar(Cidade objeto) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.create(objeto);
    }
}

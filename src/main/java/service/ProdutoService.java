package service;

import java.util.List;

import dao.impl.ProdutoDAO;
import domain.Produto;

public class ProdutoService {
   private ProdutoDAO produtoDAO;

   public ProdutoService() {
     this.produtoDAO = new ProdutoDAO();
   }

    public void createOrUpdate(Produto objeto) {
        if (objeto.getId() == null) {
            produtoDAO.create(objeto);
        } else {
            produtoDAO.update(objeto);
        }
    }
    
    public List<Produto> read() {
        return produtoDAO.read();
    }
    
    public Produto readById(Long id) {
        return produtoDAO.read(id);
    }
}

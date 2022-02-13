package service;

import java.util.List;
import model.bo.TipoProduto;
import model.DAO.objects.TipoProdutoDAO;

public class TipoProdutoService {
   private TipoProdutoDAO tipoProdutoDAO;

   public TipoProdutoService() {
     this.tipoProdutoDAO = new TipoProdutoDAO();
   }

    public void createOrUpdate(TipoProduto objeto) {
        if (objeto.getId() == null) {
            tipoProdutoDAO.create(objeto);
        } else {
            tipoProdutoDAO.update(objeto);
        }
    }
    
    public List<TipoProduto> read() {
        return tipoProdutoDAO.read();
    }
    
    public TipoProduto readById(Long id) {
        return tipoProdutoDAO.read(id);
    }
}

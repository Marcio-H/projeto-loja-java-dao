package model.dao.objects;

import java.util.List;
import model.bo.Bairro;
import model.dao.InterfaceDAO;
import model.dao.BaseDAO;

public class BairroDAO extends BaseDAO<Bairro> implements InterfaceDAO<Bairro>{

    public static void main(String[] args) {
//        Bairro bairro = new Bairro();
//        
//        bairro.setId(2L);
       
//        bairro.setDescricao("BAIRRO TESTE AGORA");
        
        BairroDAO bairroDAO = new BairroDAO();
        
        List<Bairro> bairros = bairroDAO.read();
        
        System.out.println(bairros);
        
//        bairroDAO.create(bairro);;
        
//        Bairro b = bairroDAO.read(2L);
//        
//        System.out.println(b);
    }

    public BairroDAO() {}
    
    @Override
    public void create(Bairro objeto) {
        this.abstractCreate(objeto);
    }

    @Override
    public List<Bairro> read() {
        return abstractRead(Bairro.class);
    }

    @Override
    public Bairro read(Long codigo) {
        return (Bairro) this.abstractReadById(codigo, Bairro.class);
    }

    @Override
    public void update(Bairro objeto) {
        abstractUpdate(objeto);
    }

    @Override
    public void delete(Bairro objeto) {
        abstractDelete(Bairro.class, objeto.getId());
    }
}

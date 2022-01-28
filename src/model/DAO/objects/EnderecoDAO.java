package model.dao.objects;

import java.util.List;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import model.dao.BaseDAO;
import model.dao.InterfaceDAO;

public class EnderecoDAO extends BaseDAO<Endereco> implements InterfaceDAO<Endereco>{

    public static void main(String[] args) {
        Endereco endereco = new Endereco();
        endereco.setId(7L);
        endereco.setLogradouro("LOGRADOURO ALTERADO");
        endereco.setCep("CEP ALT");
        
        Cidade cidade = new Cidade();
        Bairro bairro = new Bairro();
        
        cidade.setId(3L);
        bairro.setId(3L);
        
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        
        enderecoDAO.update(endereco);
//        Endereco e = enderecoDAO.read(5L);
//        
//        System.out.println(e);
    }
    
    public EnderecoDAO() {}

    @Override
    public void create(Endereco objeto) {
        abstractCreate(objeto);
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
    public void update(Endereco objeto) {
        abstractUpdate(objeto);
    }

    @Override
    public void delete(Endereco objeto) {
        abstractDelete(Endereco.class, objeto.getId());
    }
}

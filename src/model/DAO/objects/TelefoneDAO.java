package model.DAO.objects;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DAO.BaseDAO;
import model.DAO.InterfaceDAO;
import model.bo.Fornecedor;
import model.bo.Telefone;

public class TelefoneDAO extends BaseDAO<Telefone> implements InterfaceDAO<Telefone> {

    @Override
    public Telefone create(Telefone objeto) {
        return abstractCreate(objeto);
    }

    @Override
    public List<Telefone> read() {
        return abstractRead(Telefone.class);
    }

    @Override
    public Telefone read(Long codigo) {
        return (Telefone) abstractReadById(codigo, Telefone.class);
    }

    @Override
    public Telefone update(Telefone objeto) {
        return abstractUpdate(objeto);
    }

    @Override
    public void delete(Telefone objeto) {
        abstractDelete(Telefone.class, objeto.getId());
    }

    public List<Telefone> findByFornecedor(Fornecedor fornecedor) {
        String sql = "SELECT id, telefone, fornecedor_id FROM telefone WHERE fornecedor_id = ?";
        List<Telefone> telefones = new ArrayList<>();
        
        openConnection();
        try {
            prepareStatement(sql);
            preparedStatement.setLong(1, fornecedor.getId());
            resultSet();
            while (resultSet.next()) {
                Telefone telefone = new Telefone();
                telefone.setId(resultSet.getLong(1));
                telefone.setTelefone(resultSet.getString(2));
                telefone.getFornecedor().setId(resultSet.getLong(3));
                telefones.add(telefone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return telefones;
    }

}

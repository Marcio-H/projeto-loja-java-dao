package model.dao.objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Cidade;
import model.dao.ConnectionFactory;
import model.dao.InterfaceDAO;

public class CidadeDAO implements InterfaceDAO<Cidade>{

    @Override
    public void create(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cidade (descricao, uf) VALUES(?,?)";
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getUf());
            
            pstm.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        //fechar a conexão
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Cidade> read() {
        String sqlExecutar = " SELECT id, "
                                 + "descricao, "
                                 + "uf "
                                 + "FROM cidade";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        List<Cidade> cidades = new ArrayList<>();
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();            
            
            while(rst.next()){
                Cidade cidade = new Cidade();
                cidade.setId(rst.getLong("id"));
                cidade.setDescricao(rst.getString("descricao"));
                cidade.setUf(rst.getString("uf"));
                cidades.add(cidade);
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return cidades;
        } catch(SQLException e){
            e.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public Cidade read(Long codigo) {
        String sqlExecutar     =   " SELECT id, "
                                 + " descricao, "
                                 + " uf "
                                 + " FROM cidade "
                                 + " WHERE cidade.id = ?";
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setLong(1, codigo);
            rst = pstm.executeQuery();  
            Cidade cidade = new Cidade();
            while(rst.next()){
                cidade.setId(rst.getLong("id"));
                cidade.setDescricao(rst.getString("descricao"));
                cidade.setUf(rst.getString("uf"));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return cidade; 
        } catch(SQLException e){
            e.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public void update(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE cidade "
                           + " SET descricao   = ? ,"
                           + " uf = ? "
                           + " WHERE cidade.id = ? ";
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getUf());
            pstm.setLong(3, objeto.getId());
            pstm.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE FROM cidade WHERE id = ?";
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setLong(1, objeto.getId());
            pstm.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }
}

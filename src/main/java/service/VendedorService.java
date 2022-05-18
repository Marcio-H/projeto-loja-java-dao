package service;

import java.util.List;

import dao.impl.VendedorDAO;
import domain.Vendedor;

public class VendedorService {
    
    private VendedorDAO vendedorDAO;

    public VendedorService() {
        vendedorDAO = new VendedorDAO();
    }
    
    public Vendedor createOrUpdate(Vendedor objeto) {
        if (objeto.getId() == null) {
            return vendedorDAO.create(objeto);
        } else {
            return vendedorDAO.update(objeto);
        }
    }
    
    public List<Vendedor> read() {
        return vendedorDAO.read();
    }
    
    public Vendedor readById(Long codigo) {
        return vendedorDAO.read(codigo);
    }
}

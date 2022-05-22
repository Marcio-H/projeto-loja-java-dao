package service.telefones;

import java.util.List;

import dao.impl.TelefoneClienteDao;
import domain.TelefoneCliente;

public class TelefoneClienteService implements BaseServiceTelefone<TelefoneCliente> {
	
    private TelefoneClienteDao telefoneClienteDao;

    public TelefoneClienteService() {
    	telefoneClienteDao = new TelefoneClienteDao();
   }

    public void createOrUpdate(TelefoneCliente objeto) {
        if (objeto.getId() == null) {
        	telefoneClienteDao.create(objeto);
        } else {
        	telefoneClienteDao.update(objeto);
        }
    }
    
    public List<TelefoneCliente> read() {
        return telefoneClienteDao.read();
    }
    
    public TelefoneCliente readById(Long id) {
        return telefoneClienteDao.read(id);
    }
}

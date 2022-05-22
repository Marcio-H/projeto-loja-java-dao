package service.telefones;

import java.util.List;

import dao.impl.TelefoneVendedorDAO;
import domain.TelefoneVendedor;

public class TelefoneVendedorService implements BaseServiceTelefone<TelefoneVendedor> {

	private TelefoneVendedorDAO telefoneVendedorDAO;
	
	public TelefoneVendedorService() {
		this.telefoneVendedorDAO = new TelefoneVendedorDAO();
	}

	@Override
	public void createOrUpdate(TelefoneVendedor objeto) {
		if (objeto.getId() == null) {
			telefoneVendedorDAO.create(objeto);
	    } else {
	    	telefoneVendedorDAO.update(objeto);
	    }		
	}

	@Override
	public List<TelefoneVendedor> read() {
		return telefoneVendedorDAO.read();
	}

	@Override
	public TelefoneVendedor readById(Long id) {
		return telefoneVendedorDAO.read(id);
	}
	
}

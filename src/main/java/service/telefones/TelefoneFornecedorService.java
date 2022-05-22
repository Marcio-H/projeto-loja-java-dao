package service.telefones;

import java.util.List;

import dao.impl.TelefoneFornecedorDAO;
import domain.TelefoneFornecedor;

public class TelefoneFornecedorService implements BaseServiceTelefone<TelefoneFornecedor> {
	
	private TelefoneFornecedorDAO telefoneFornecedorDAO;
	
	public TelefoneFornecedorService() {
		this.telefoneFornecedorDAO = new TelefoneFornecedorDAO();
	}

	@Override
	public void createOrUpdate(TelefoneFornecedor objeto) {
		if (objeto.getId() == null) {
			telefoneFornecedorDAO.create(objeto);
	    } else {
	    	telefoneFornecedorDAO.update(objeto);
	    }
	}

	@Override
	public List<TelefoneFornecedor> read() {
		return telefoneFornecedorDAO.read();
	}

	@Override
	public TelefoneFornecedor readById(Long id) {
		return telefoneFornecedorDAO.read(id);
	}

}

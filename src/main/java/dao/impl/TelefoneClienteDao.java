package dao.impl;

import domain.TelefoneCliente;

public class TelefoneClienteDao extends BaseDAOImpl<TelefoneCliente, Long> {

	TelefoneClienteDao() {
		super(TelefoneCliente.class, TelefoneCliente::getId);
	}

}

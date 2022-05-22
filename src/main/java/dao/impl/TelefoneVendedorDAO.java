package dao.impl;

import domain.TelefoneVendedor;

public class TelefoneVendedorDAO extends BaseDAOImpl<TelefoneVendedor, Long> {

	TelefoneVendedorDAO() {
		super(TelefoneVendedor.class, TelefoneVendedor::getId);
	}

}

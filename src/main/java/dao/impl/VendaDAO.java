package dao.impl;

import domain.Venda;

public class VendaDAO extends BaseDAOImpl<Venda, Long> {

	public VendaDAO() {
		super(Venda.class, Venda::getId);
	}

}

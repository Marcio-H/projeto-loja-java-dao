package dao.impl;

import domain.ItensVenda;

public class ItensVendaDAO extends BaseDAOImpl<ItensVenda, Long> {

	ItensVendaDAO() {
		super(ItensVenda.class, ItensVenda::getId);
	}

}

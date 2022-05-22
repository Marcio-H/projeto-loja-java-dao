package dao.impl;

import domain.Receber;

public class ReceberDAO extends BaseDAOImpl<Receber, Long> {

	ReceberDAO() {
		super(Receber.class, Receber::getId);
	}

}

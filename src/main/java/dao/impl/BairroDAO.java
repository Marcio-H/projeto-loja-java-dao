package dao.impl;

import domain.Bairro;

public class BairroDAO extends BaseDAOImpl<Bairro, Long>{

	public BairroDAO() {
		super(Bairro.class, Bairro::getId);
	}
}

package dao.impl;

import domain.Cidade;

public class CidadeDAO extends BaseDAOImpl<Cidade, Long> {

	public CidadeDAO() {
		super(Cidade.class, Cidade::getId);
	}

}

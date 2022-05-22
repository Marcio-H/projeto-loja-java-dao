package dao.impl;

import domain.CondicaoPagamento;
import domain.Cor;

public class CorDAO extends BaseDAOImpl<Cor, Long>{

	public CorDAO() {
		super(Cor.class, Cor::getId);
	}

}

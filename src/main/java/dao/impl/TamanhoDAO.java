package dao.impl;

import domain.Tamanho;

public class TamanhoDAO extends BaseDAOImpl<Tamanho, Long> {

	public TamanhoDAO() {
		super(Tamanho.class, Tamanho::getId);
	}

}

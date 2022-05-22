package dao.impl;

import domain.Tamanho;

public class TamanhoDAO extends BaseDAOImpl<Tamanho, Long> {

	TamanhoDAO() {
		super(Tamanho.class, Tamanho::getId);
	}

}

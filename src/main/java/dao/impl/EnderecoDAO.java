package dao.impl;

import domain.Endereco;

public class EnderecoDAO extends BaseDAOImpl<Endereco, Long> {

	public EnderecoDAO() {
		super(Endereco.class, Endereco::getId);
	}

}

package dao.impl;

import domain.Produto;

public class ProdutoDAO extends BaseDAOImpl<Produto, Long> {

	public ProdutoDAO() {
		super(Produto.class, Produto::getId);
	}

}

package dao.impl;

import domain.Produto;

public class ProdutoDAO extends BaseDAOImpl<Produto, Long> {

	ProdutoDAO() {
		super(Produto.class, Produto::getId);
	}

}

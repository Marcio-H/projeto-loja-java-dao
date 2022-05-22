package dao.impl;

import domain.TipoProduto;


public class TipoProdutoDAO extends BaseDAOImpl<TipoProduto, Long> {

	TipoProdutoDAO() {
		super(TipoProduto.class, TipoProduto::getId);
	}

}


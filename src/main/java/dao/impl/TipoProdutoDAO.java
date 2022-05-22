package dao.impl;

import domain.TipoProduto;


public class TipoProdutoDAO extends BaseDAOImpl<TipoProduto, Long> {

	public TipoProdutoDAO() {
		super(TipoProduto.class, TipoProduto::getId);
	}

}


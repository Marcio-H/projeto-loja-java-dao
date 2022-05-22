package dao.impl;

import domain.Fornecedor;

public class FornecedorDAO extends BaseDAOImpl<Fornecedor, Long> {

	public FornecedorDAO(Class<Fornecedor> claz) {
		super(Fornecedor.class);
	}
}

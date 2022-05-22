package dao.impl;

import domain.Fornecedor;

public class FornecedorDAO extends BaseDAOImpl<Fornecedor, Long> {

	public FornecedorDAO() {
		super(Fornecedor.class, Fornecedor::getId);
	}
}

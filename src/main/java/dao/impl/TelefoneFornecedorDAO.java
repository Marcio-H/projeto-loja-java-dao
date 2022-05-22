package dao.impl;

import domain.TelefoneFornecedor;

// TODO: Telefone Cliente e Telefone vendedor
public class TelefoneFornecedorDAO extends BaseDAOImpl<TelefoneFornecedor, Long> {

	public TelefoneFornecedorDAO() {
		super(TelefoneFornecedor.class, TelefoneFornecedor::getId);
	}

}

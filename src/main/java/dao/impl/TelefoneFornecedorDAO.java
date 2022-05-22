package dao.impl;

import domain.TelefoneFornecedor;

// TODO: Telefone Cliente e Telefone vendedor
public class TelefoneFornecedorDAO extends BaseDAOImpl<TelefoneFornecedor, Long> {

	TelefoneFornecedorDAO() {
		super(TelefoneFornecedor.class, TelefoneFornecedor::getId);
	}

}

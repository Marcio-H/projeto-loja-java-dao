package dao.impl;


import domain.Vendedor;

public class VendedorDAO extends BaseDAOImpl<Vendedor, Long> {

	public VendedorDAO() {
		super(Vendedor.class, Vendedor::getId);
	}

}
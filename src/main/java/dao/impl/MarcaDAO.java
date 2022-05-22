package dao.impl;


import domain.Marca;

public class MarcaDAO extends BaseDAOImpl<Marca, Long> {

	public MarcaDAO() {
		super(Marca.class, Marca::getId);
	}

}

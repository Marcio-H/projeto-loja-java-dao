package dao.impl;


import domain.Marca;

public class MarcaDAO extends BaseDAOImpl<Marca, Long> {

	MarcaDAO() {
		super(Marca.class, Marca::getId);
	}

}

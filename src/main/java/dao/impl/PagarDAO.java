package dao.impl;


import domain.Pagar;

public class PagarDAO extends BaseDAOImpl<Pagar, Long> {

	PagarDAO() {
		super(Pagar.class, Pagar::getId);
	}

}

package dao.impl;

import domain.CaracteristicaProduto;

public class CaracteristicaProdutoDAO extends BaseDAOImpl<CaracteristicaProduto, Long> {

	CaracteristicaProdutoDAO() {
		super(CaracteristicaProduto.class, CaracteristicaProduto::getId);
	}
}

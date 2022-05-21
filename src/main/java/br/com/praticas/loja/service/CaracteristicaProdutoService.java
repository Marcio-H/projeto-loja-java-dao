package br.com.praticas.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.praticas.loja.model.CaracteristicaProduto;

public interface CaracteristicaProdutoService {

	CaracteristicaProduto save(CaracteristicaProduto caracteristicaProduto);
	List<CaracteristicaProduto> findAll();
	Optional<CaracteristicaProduto> findById(Long id);
	void delete(CaracteristicaProduto caracteristicaProduto);
}

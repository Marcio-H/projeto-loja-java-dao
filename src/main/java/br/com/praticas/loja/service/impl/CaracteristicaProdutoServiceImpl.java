package br.com.praticas.loja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.praticas.loja.model.CaracteristicaProduto;
import br.com.praticas.loja.repository.CaracteristicaProdutoRepository;
import br.com.praticas.loja.service.CaracteristicaProdutoService;

@Service
public class CaracteristicaProdutoServiceImpl implements CaracteristicaProdutoService {

	@Autowired
	private CaracteristicaProdutoRepository caracteristicaProdutoRepository;

	@Override
	public CaracteristicaProduto save(CaracteristicaProduto caracteristicaProduto) {
		return caracteristicaProdutoRepository.save(caracteristicaProduto);
	}

	@Override
	public List<CaracteristicaProduto> findAll() {
		return caracteristicaProdutoRepository.findAll();
	}

	@Override
	public Optional<CaracteristicaProduto> findById(Long id) {
		return caracteristicaProdutoRepository.findById(id);
	}

	@Override
	public void delete(CaracteristicaProduto caracteristicaProduto) {
		caracteristicaProdutoRepository.delete(caracteristicaProduto);	
	}
}

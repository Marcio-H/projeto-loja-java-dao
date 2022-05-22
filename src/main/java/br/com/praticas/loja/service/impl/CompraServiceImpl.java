package br.com.praticas.loja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.praticas.loja.model.Compra;
import br.com.praticas.loja.repository.CompraRepository;
import br.com.praticas.loja.service.CompraService;

@Service
public class CompraServiceImpl implements CompraService {
	
	@Autowired
	private CompraRepository compraRepository;

	@Override
	public Compra save(Compra compra) {
		return compraRepository.save(compra);
	}

	@Override
	public List<Compra> findAll() {
		return compraRepository.findAll();
	}

	@Override
	public Optional<Compra> findById(Long id) {
		return compraRepository.findById(id);
	}

	@Override
	public void delete(Compra compra) {
		compraRepository.delete(compra);	
	}
}

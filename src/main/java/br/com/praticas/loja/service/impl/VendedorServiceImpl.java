package br.com.praticas.loja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.praticas.loja.model.Vendedor;
import br.com.praticas.loja.repository.VendedorRepository;
import br.com.praticas.loja.service.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;

	@Override
	public Vendedor save(Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}

	@Override
	public List<Vendedor> findAll() {
		return vendedorRepository.findAll();
	}

	@Override
	public Optional<Vendedor> findById(Long id) {
		return vendedorRepository.findById(id);
	}

	@Override
	public void delete(Vendedor vendedor) {
		vendedorRepository.delete(vendedor);	
	}
}

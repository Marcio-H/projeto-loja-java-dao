package br.com.praticas.loja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.praticas.loja.model.Fornecedor;
import br.com.praticas.loja.repository.FornecedorRepository;
import br.com.praticas.loja.service.FornecedorService;

@Service
public class FornecedorServiceImpl implements FornecedorService {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Override
	public Fornecedor save(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}

	@Override
	public List<Fornecedor> findAll() {
		return fornecedorRepository.findAll();
	}

	@Override
	public Optional<Fornecedor> findById(Long id) {
		return fornecedorRepository.findById(id);
	}

	@Override
	public void delete(Fornecedor fornecedor) {
		fornecedorRepository.delete(fornecedor);	
	}
}
